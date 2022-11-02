package helpers.configuration.yamlmodels;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Browser {

    Map<String, Object> browserProperties = new LinkedHashMap<>();

    @JsonAnySetter
    void setBrowserProperties (String key, Object value) {
        browserProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getBrowserProperties() {
        return browserProperties;
    }
}
