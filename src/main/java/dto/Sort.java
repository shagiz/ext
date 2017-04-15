package dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.ws.rs.WebApplicationException;
import java.io.IOException;
import java.util.List;

public class Sort {
    private String property;
    private String direction;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public static Sort fromString(String jsonRepresentation) {
        ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
        Sort o = null;
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        try {
            o = ((List<Sort>) mapper.readValue(jsonRepresentation, typeFactory.constructCollectionType(List.class, Sort.class))).get(0);
        } catch (IOException e) {
            throw new WebApplicationException();
        }
        return o;
    }
}
