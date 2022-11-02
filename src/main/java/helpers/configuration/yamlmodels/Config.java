package helpers.configuration.yamlmodels;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Config {

    public String activeEnvironment;
    public Environments environment;
    public Browser browser;
}
