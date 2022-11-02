package helpers.configuration.factory;

import helpers.configuration.reader.YamlReader;
import helpers.configuration.yamlmodels.Browser;
import helpers.configuration.yamlmodels.EnvironmentFields;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PropertiesFactory {

    YamlReader yamlReader = new YamlReader();
    private List<EnvironmentFields> listOfEnvironments;
    protected Browser browser;

    private PropertiesFactory() {
        setBrowserProperties();
        setEnvironmentVariables();
    }

    public static PropertiesFactory getInstance() {
        return PropertiesFactory.PropertiesFactorySingleton.INSTANCE;
    }

    private static class PropertiesFactorySingleton {
        private static final PropertiesFactory INSTANCE = new PropertiesFactory();
    }

    private void setEnvironmentVariables() {
        String activeEnvironment = yamlReader.getConfig().getActiveEnvironment();
        listOfEnvironments = yamlReader.getConfig().getEnvironment().getEnvironments();
        for (EnvironmentFields environmentFields : listOfEnvironments) {
            Object loadedEnvironment = environmentFields.getProperties().get("environmentName");
            if (Objects.equals(activeEnvironment, loadedEnvironment)) {
                Map<String, Object> envProperties = environmentFields.getProperties();
                for (Map.Entry entry : envProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                }
                break;
            }
        }
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
