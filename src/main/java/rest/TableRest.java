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

            object.addProperty("total", genericDao.findAll().size());
            object.add("data", jsonElement.getAsJsonArray());
            return Response.ok(object.toString()).build();
        }
        return Response.noContent().build();
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
        }
        return null;
    }

    private Response getColumnsResponse(String entity) {
        List<Column> columns = new ArrayList<>();
        try {
            Class clazz = Class.forName("entity." + entity);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                boolean readOnly = false;
                boolean allowBlank = true;
                String fieldType = "textfield";

                if ("headClue".equals(field.getName()) || "bknumber".equals(field.getName())) {
                    allowBlank = false;
                }

                if ("headClue".equals(field.getName())) {
                    readOnly = true;
                }

                if (field.getType() == Integer.TYPE
                        || field.getType() == Integer.class
                        || field.getType() == Long.TYPE
                        || field.getType() == Float.TYPE
                        || field.getType() == Float.class
                        || field.getType() == Double.TYPE
                        || field.getType() == Double.class) {
                    fieldType = "numberfield";
                }

                columns.add(new Column(field.getName(), field.getName(), 1 % field.getName().length(), allowBlank, readOnly, fieldType));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Response.ok(
                columns
        ).build();
    }
}
