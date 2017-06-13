package rest;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import dao.interfaces.AllDao;
import dao.interfaces.BiblioDao;
import dao.interfaces.ElementDao;
import dao.interfaces.GenericDao;
import dto.Column;
import dto.Filter;
import dto.Sort;
import entity.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/table")
@Produces(MediaType.APPLICATION_JSON)
public class TableRest {

    @Inject
    private AllDao allDao;

    @GET
    @Path("/elements")
    public Response getElements(@QueryParam("page") int page,
                                @QueryParam("start") int start,
                                @QueryParam("limit") int limit,
                                @QueryParam("sort") Sort sorts,
                                @QueryParam("filter") Filter filter) {
        ElementDao elementDao = allDao.getElementDao();

        if (elementDao != null) {
            JsonObject object = new JsonObject();
            Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                    return fieldAttributes.getAnnotation(Expose.class) != null;
                }

                @Override
                public boolean shouldSkipClass(Class<?> aClass) {
                    return false;
                }
            }).serializeNulls().create();

            JsonParser parser = new JsonParser();
            JsonElement jsonElement;

            jsonElement = parser.parse(gson.toJson(elementDao.findAll(page, start, limit, sorts, filter)));


            object.addProperty("total", elementDao.findAll().size());
            object.add("data", jsonElement.getAsJsonArray());

            return Response.ok(object.toString()).build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/columns")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getColumns(@QueryParam("entity") String entity) {
        return getColumnsResponse(entity);
    }

    @GET
    public Response getData(@QueryParam("entity") String entity,
                            @QueryParam("page") int page,
                            @QueryParam("start") int start,
                            @QueryParam("limit") int limit,
                            @QueryParam("bkNumber") Integer bkNumber,
                            @QueryParam("headClue") Integer headClue,
                            @QueryParam("sort") Sort sort) {
        GenericDao genericDao = getDao(entity);
        if (genericDao != null) {
            JsonObject object = new JsonObject();
            Gson gson = new Gson();

            JsonParser parser = new JsonParser();
            JsonElement jsonElement;

            if (genericDao instanceof BiblioDao && bkNumber != null && bkNumber > 0) {
                jsonElement = parser.parse(gson.toJson(((BiblioDao) genericDao).findAllByBk(page, start, limit, bkNumber)));
            } else {
                jsonElement = parser.parse(gson.toJson(genericDao.findAll(page, start, limit, sort, headClue)));
            }

            object.addProperty("total", genericDao.count(headClue));
            object.add("data", jsonElement.getAsJsonArray());
            return Response.ok(object.toString()).build();
        }
        return Response.noContent().build();
    }

    private GenericDao getDao(String entity) {
        switch (entity) {
            case "Acop":
                return allDao.getAcopDao();
            case "Density":
                return allDao.getDensityDao();
            case "Sist":
                return allDao.getSistDao();
            case "Heat":
                return allDao.getHeatDao();
            case "Biblio":
                return allDao.getBiblioDao();
            case "PzEl":
                return allDao.getPzElDao();
            case "Hard":
                return allDao.getHardTablDao();
            case "SuspTabl":
                return allDao.getSuspDao();
            case "PlavTabl":
                return allDao.getPlavTablDao();
            case "CuryTabl":
                return allDao.getCuryTablDao();
            case "ElemTabl":
                return allDao.getElemTablDao();
            case "HeatExpn":
                return allDao.getHeatExpnDao();
            case "Dielectr":
                return allDao.getDielectrDao();
            case "DielDiss":
                return allDao.getDielDissDao();
            case "MechTabl":
                return allDao.getMechTablDao();
            case "Elastic1":
                return allDao.getElastic1Dao();
            case "Wavepure":
                return allDao.getWavepureDao();
            case "RefrcInd":
                return allDao.getRefrcIndDao();
            case "ConstSel":
                return allDao.getConstSelDao();
            case "ElOpTabl":
                return allDao.getElOpTablDao();
            case "NlOpTabl":
                return allDao.getNlOpTablDao();
            case "MNOpTabl":
                return allDao.getMNOpTablDao();
            case "EsOpTabl":
                return allDao.getEsOpTablDao();
            case "DecrTabl":
                return allDao.getDecrTablDao();
        }
        return null;
    }

    private Response getColumnsResponse(String entity) {
        List<Column> columns = new ArrayList<>();
        try {
            Class clazz = Class.forName("entity." + entity);
            Field[] classFields = clazz.getDeclaredFields();
            List<Field> fields = Arrays.asList(classFields);
            if (clazz.getSuperclass().equals(BaseHeadClueEntity.class)) {
                fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
                fields.addAll(Arrays.asList(classFields));
            }

            for (Field field : fields) {
                boolean readOnly = false;
                boolean allowBlank = true;
                String fieldType = "textfield";
                int fieldLength = 0;

                if (field.getType() == Integer.TYPE
                        || field.getType() == Integer.class
                        || field.getType() == Long.TYPE
                        || field.getType() == Float.TYPE
                        || field.getType() == Float.class
                        || field.getType() == Double.TYPE
                        || field.getType() == Double.class) {
                    fieldType = "numberfield";
                }

                String name = field.getName();
                if (field.getAnnotation(ColumnProperty.class) != null) {
                    ColumnProperty columnProperty = field.getAnnotation(ColumnProperty.class);
                    name = columnProperty.name();
                    allowBlank = columnProperty.allowBlank();
                    readOnly = columnProperty.readOnly();
                    fieldLength = columnProperty.fieldLength();
                }

                columns.add(new Column(
                                name,
                                field.getName(),
                                1 % field.getName().length(),
                                allowBlank,
                                readOnly,
                                fieldType,
                                fieldLength
                        )
                );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Response.ok(
                columns
        ).build();
    }


    @POST
    @Path("/Acop")
    @Consumes("application/json")
    public Response putAcop(List<Acop> data) {
        GenericDao<Acop> genericDao = allDao.getAcopDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Biblio")
    @Consumes("application/json")
    public Response putBiblio(List<Biblio> data) {
        GenericDao<Biblio> genericDao = allDao.getBiblioDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/ConstSel")
    @Consumes("application/json")
    public Response putConstSel(List<ConstSel> data) {
        GenericDao<ConstSel> genericDao = allDao.getConstSelDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/CuryTabl")
    @Consumes("application/json")
    public Response putCuryTabl(List<CuryTabl> data) {
        GenericDao<CuryTabl> genericDao = allDao.getCuryTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/DecrTabl")
    @Consumes("application/json")
    public Response putDecrTabl(List<DecrTabl> data) {
        GenericDao<DecrTabl> genericDao = allDao.getDecrTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Density")
    @Consumes("application/json")
    public Response putDensity(List<Density> data) {
        GenericDao<Density> genericDao = allDao.getDensityDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/DielDiss")
    @Consumes("application/json")
    public Response putDielDiss(List<DielDiss> data) {
        GenericDao<DielDiss> genericDao = allDao.getDielDissDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Dielectr")
    @Consumes("application/json")
    public Response putDielectr(List<Dielectr> data) {
        GenericDao<Dielectr> genericDao = allDao.getDielectrDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Elastic1")
    @Consumes("application/json")
    public Response putElastic1(List<Elastic1> data) {
        GenericDao<Elastic1> genericDao = allDao.getElastic1Dao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Element")
    @Consumes("application/json")
    public Response putElement(List<Element> data) {
        GenericDao<Element> genericDao = allDao.getElementDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/ElemTabl")
    @Consumes("application/json")
    public Response putElemTabl(List<ElemTabl> data) {
        GenericDao<ElemTabl> genericDao = allDao.getElemTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/ElOpTabl")
    @Consumes("application/json")
    public Response putElOpTabl(List<ElOpTabl> data) {
        GenericDao<ElOpTabl> genericDao = allDao.getElOpTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/EsOpTabl")
    @Consumes("application/json")
    public Response putEsOpTabl(List<EsOpTabl> data) {
        GenericDao<EsOpTabl> genericDao = allDao.getEsOpTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/HardTabl")
    @Consumes("application/json")
    public Response putHardTabl(List<HardTabl> data) {
        GenericDao<HardTabl> genericDao = allDao.getHardTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Heat")
    @Consumes("application/json")
    public Response putHeat(List<Heat> data) {
        GenericDao<Heat> genericDao = allDao.getHeatDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/HeatExpn")
    @Consumes("application/json")
    public Response putHeatExpn(List<HeatExpn> data) {
        GenericDao<HeatExpn> genericDao = allDao.getHeatExpnDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/MechTabl")
    @Consumes("application/json")
    public Response putMechTabl(List<MechTabl> data) {
        GenericDao<MechTabl> genericDao = allDao.getMechTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/MNOpTabl")
    @Consumes("application/json")
    public Response putMNOpTabl(List<MNOpTabl> data) {
        GenericDao<MNOpTabl> genericDao = allDao.getMNOpTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/NlOpTabl")
    @Consumes("application/json")
    public Response putNlOpTabl(List<NlOpTabl> data) {
        GenericDao<NlOpTabl> genericDao = allDao.getNlOpTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/PlavTabl")
    @Consumes("application/json")
    public Response putPlavTabl(List<PlavTabl> data) {
        GenericDao<PlavTabl> genericDao = allDao.getPlavTablDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/PzEl")
    @Consumes("application/json")
    public Response putPzEl(List<PzEl> data) {
        GenericDao<PzEl> genericDao = allDao.getPzElDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/RefrcInd")
    @Consumes("application/json")
    public Response putRefrcInd(List<RefrcInd> data) {
        GenericDao<RefrcInd> genericDao = allDao.getRefrcIndDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Sist")
    @Consumes("application/json")
    public Response putSist(List<Sist> data) {
        GenericDao<Sist> genericDao = allDao.getSistDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/SuspTabl")
    @Consumes("application/json")
    public Response putSuspTabl(List<SuspTabl> data) {
        GenericDao<SuspTabl> genericDao = allDao.getSuspDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Wavepure")
    @Consumes("application/json")
    public Response putWavepure(List<Wavepure> data) {
        GenericDao<Wavepure> genericDao = allDao.getWavepureDao();

        if (genericDao != null) {
            data.forEach(genericDao::update);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }
}
