package helpers.configuration.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import helpers.configuration.yamlmodels.Config;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class YamlReader {


    private static Logger logger = LoggerFactory.getLogger("YamlReader.class");

    private Config config;

    @SneakyThrows
    public YamlReader() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        this.config = mapper.readValue(new File("src/main/resources/config.yaml"), Config.class);
        logger.info("<------------------Config yaml file has been read------------------>");
    }

    public Config getConfig() {
        return config;
    }
}
