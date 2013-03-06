// -----
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To view a copy // of this license, visit http://creativecommons.org/licenses/by/3.0/.
// -----

import java.io.*;
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
    public static void main(String [ ] args) throws Exception {
        String pathToConfigFile = "test/resources/test-config.yaml";

        DeployConfig deployConfig = new DeployConfig(pathToConfigFile);
        Deploy deploy = new Deploy(deployConfig);

        System.out.println("--------------------");
        System.out.println("Testing Deploy Constructor");
        System.out.println("--------------------");
        if ( deploy instanceof Deploy ) {
            System.out.println("correct: deploy is instace of Deploy!");
        }


        System.out.println("--------------------");
        System.out.println("Testing compress file");
        System.out.println("--------------------");

        deploy.run();

        // validate compress file exists
        String version = "1.0";
        String deployPath = "test/resources/deploy/";
        String projectName = "deploytest";
        String expectedCompressFileName = projectName+"-"+version+".tar.gz";
        String deployedFileFullPath = deployPath + expectedCompressFileName;

        System.out.println("Testing that file: "+deployedFileFullPath + " exists. ");
        File compressedFile = new File( deployedFileFullPath );

        if ( compressedFile.exists() ) {
            System.out.println("correct: compress file exists!");
            if ( compressedFile.isFile() ){
                System.out.println("correct: and it's a file!");
            } else {
                System.out.println("error!!: and it's a file!");
            }
        } else {
            System.out.println("error!!: file not found: "+ deployedFileFullPath +" !");
        }
        
    }
}