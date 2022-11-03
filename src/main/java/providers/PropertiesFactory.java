package providers;

import helpers.reader.YamlReader;
import models.yamlmodels.Browser;
import models.yamlmodels.Environment;
import models.yamlmodels.TestData;

import java.util.Map;

public class PropertiesFactory {

    YamlReader yamlReader = new YamlReader();
    protected Environment environment;
    protected Browser browser;

    protected TestData testData;

    private PropertiesFactory() {
        setBrowserProperties();
        setEnvironmentProperties();
        setDataProperties();
    }

    public static PropertiesFactory getInstance() {
        return PropertiesFactory.PropertiesFactorySingleton.INSTANCE;
    }

    private static class PropertiesFactorySingleton {
        private static final PropertiesFactory INSTANCE = new PropertiesFactory();
    }

    private void setEnvironmentProperties() {
        environment = yamlReader.getConfig().getEnvironment();
        Map<String, Object> envProperties = environment.getProperties();
        for (Map.Entry entry : envProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private void setDataProperties() {
        testData = yamlReader.getConfig().getTestData();
        Map<String, Object> dataProperties = testData.getDataProperties();
        for (Map.Entry entry : dataProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
