// -----
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To view a copy // of this license, visit http://creativecommons.org/licenses/by/3.0/.
// -----

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.yaml.snakeyaml.Yaml;

/**
 * @author      Daniel Zamorano <daniel.zamorano.m@gmail.com>
 * @version     0.1
 * @since       2013-03-01
 */

public class DeployConfig {
    private static String pathToConfigFile = new String();
    private static HashMap<String, String> configData;

    public DeployConfig( String configFilePath ) throws IOException {
        pathToConfigFile = configFilePath;
        configData = loadYAMLFile(pathToConfigFile);
    }

    public HashMap<String, String> getAllConfig(){
        return configData;
    }

    private HashMap<String, String> loadYAMLFile(String pathToFile) throws IOException {
        InputStream input = new FileInputStream(new File(pathToFile));
        Yaml yaml = new Yaml();
        @SuppressWarning
        // this is trowing an unchecked cast warning
        // need to research
        HashMap<String, String> yamlContent = (HashMap<String, String>) yaml.load(input);
        System.out.println(yamlContent);
        return yamlContent;
    }

    public String getConfigValue( String configName ){
        String configValue = configData.get(configName);

        if ( configValue != null ) {
            return configValue;
        }

        return null;
    }
}