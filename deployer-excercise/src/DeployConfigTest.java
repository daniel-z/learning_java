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

public class DeployConfigTest {
    public static void main(String [ ] args) throws IOException {
        String pathToConfigFile = "test/resources/test-config.yaml";

        DeployConfig deployConfig = new DeployConfig(pathToConfigFile);

        System.out.println("--------------------");
        System.out.println("Testing Constructor");
        System.out.println("--------------------");
 
        if (!( deployConfig instanceof DeployConfig ) ){
            System.out.println("Error: deployConfig is not instanceof DeployConfig.");
        }
        else {
            System.out.println("Correct: deployConfig is an instanceof DeployConfig.");
        }

        System.out.println("--------------------");
        System.out.println("Testing getAllConfig");
        System.out.println("--------------------");
        HashMap<String, String> expectedResult = new HashMap<String, String>(){{
            put("project-name","deploytest");
            put("deploy-path","test/resources/deploy");
            put("path-to-project","test/resources/");
            put("main-folder","site");
            put("release-main-folder","test/resources/release");
            put("version","1.0");
        }};

        HashMap<String, String> result = deployConfig.getAllConfig();
        for ( String key : expectedResult.keySet() ) {

            String expected = expectedResult.get(key);
            String resulted   = result.get(key);

            if ( expected.equals(resulted) ){
                System.out.println("correct!: " +key+ " is... \'" + resulted + "\'");
            } else {
                System.out.println( "error!: " +key+ " is... \'" + resulted + "\'");
                System.out.println( "    expected: " + "\'" + expected + "\'");
            }
        }
        
        System.out.println("--------------------");
        System.out.println("Testing getConfigValue");
        System.out.println("--------------------");

        for ( String key : expectedResult.keySet() ) {

            String expected = expectedResult.get(key);
            String resulted = deployConfig.getConfigValue(key);

            if ( expected.equals(resulted) ){
                System.out.println("correct!: " +key+ " is... \'" + resulted + "\'");
            } else {
                System.out.println( "error!: " +key+ " is... \'" + resulted + "\'");
                System.out.println( "    expected: " + "\'" + expected + "\'");
            }
        }
    }
}