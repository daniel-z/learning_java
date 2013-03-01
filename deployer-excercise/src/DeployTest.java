// -----
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To view a copy // of this license, visit http://creativecommons.org/licenses/by/3.0/.
// -----

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

public class DeployTest {
    public static void main(String [ ] args) throws IOException {
        public static void main(String [ ] args) throws IOException {
            String pathToConfigFile = "src/config.yaml";

            DeployConfig deployConfig = new DeployConfig(pathToConfigFile);
            Deploy deploy = new Deploy(deployConfig);

            System.out.println("--------------------");
            System.out.println("Testing Deploy Constructor");
            System.out.println("--------------------");
            if ( deploy instanceof Deploy ) {
                System.out.println("correct: deploy is instace of Deploy!");
            }
        }
    }
}