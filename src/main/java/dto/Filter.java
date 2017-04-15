package dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.ws.rs.WebApplicationException;
import java.io.IOException;
import java.util.List;

public class Filter {
    private String operator;
    private String value;
    private String property;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public static Filter fromString(String jsonRepresentation) {
        ObjectMapper mapper = new ObjectMapper(); //Jackson's JSON marshaller
        Filter o = null;
        try {
            o = ((List<Filter>) mapper.readValue(jsonRepresentation, new TypeReference<List<Filter>>() { })).get(0);
        } catch (IOException e) {
            throw new WebApplicationException();
        }
        return o;
    }
}
