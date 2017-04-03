package rest;

import com.google.gson.*;
import dao.interfaces.AllDao;
import dao.interfaces.BiblioDao;
import dao.interfaces.GenericDao;
import dto.Column;
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
    AllDao allDao;

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
                            @QueryParam("bkNumber") Integer bkNumber) {
        GenericDao genericDao = getDao(entity);
        if (genericDao != null) {
            JsonObject object = new JsonObject();
            Gson gson = new Gson();

            JsonParser parser = new JsonParser();
            JsonElement tradeElement;

            if (genericDao instanceof BiblioDao && bkNumber != null && bkNumber > 0) {
                tradeElement = parser.parse(gson.toJson(((BiblioDao) genericDao).findAllByBk(page, start, limit, bkNumber)));
            } else {
                tradeElement = parser.parse(gson.toJson(genericDao.findAll(page, start, limit)));
            }

            object.addProperty("total", genericDao.findAll().size());
            object.add("data", tradeElement.getAsJsonArray());
            return Response.ok(object.toString()).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("/Acop")
    @Consumes("application/json")
    public Response putAcop(Acop acop) {
        GenericDao<Acop> genericDao = allDao.getAcopDao();

        if (genericDao != null) {
            return Response.ok(genericDao.update(acop)).build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Density")
    @Consumes("application/json")
    public Response putDensity(Density density) {
        GenericDao<Density> genericDao = allDao.getDensityDao();

        if (genericDao != null) {
            return Response.ok(genericDao.update(density)).build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Sist")
    @Consumes("application/json")
    public Response putDensity(Sist sist) {
        GenericDao<Sist> genericDao = allDao.getSistDao();

        if (genericDao != null) {
            return Response.ok(genericDao.update(sist)).build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Heat")
    @Consumes("application/json")
    public Response putDensity(Heat heat) {
        GenericDao<Heat> genericDao = allDao.getHeatDao();

        if (genericDao != null) {
            return Response.ok(genericDao.update(heat)).build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/Biblio")
    @Consumes("application/json")
    public Response putBiblio(Biblio heat) {
        GenericDao<Biblio> genericDao = allDao.getBiblioDao();

        if (genericDao != null) {
            return Response.ok(genericDao.update(heat)).build();
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
        }
        return null;
    }

    private Response getColumnsResponse(String entity) {
        List<Column> columns = new ArrayList<>();
        try {
            Class clazz = Class.forName("entity." + entity);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                columns.add(new Column(field.getName(), field.getName(), 1 % field.getName().length()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Response.ok(
                columns
        ).build();
    }
}
