package models.yamlmodels;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestData {

    Map<String, Object> dataProperties = new LinkedHashMap<>();

    @JsonAnySetter
    void setDataProperties (String key, Object value) {
        dataProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getDataProperties() {
        return dataProperties;
    }
}
