package helpers.configuration.yamlmodels;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Environments {

    Map<String, EnvironmentFields> environments = new LinkedHashMap<>();

    @JsonAnySetter
    void setEnvironments(String key, EnvironmentFields envField) {
        this.environments.put(key, envField);
    }

    @JsonAnyGetter
    public List<EnvironmentFields> getEnvironments() {
        return this.environments.values().stream().toList();
    }
}
