package models.yamlmodels;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Config {

    public Environment environment;
    public Browser browser;
    public TestData testData;
}
