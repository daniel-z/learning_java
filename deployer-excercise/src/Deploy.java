// -----
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To view a copy // of this license, visit http://creativecommons.org/licenses/by/3.0/.
// -----

/**
 * @author      Daniel Zamorano <daniel.zamorano.m@gmail.com>
 * @version     0.1
 * @since       2013-03-01
 */

import java.io.*;
import java.util.*;
import java.util.zip.*;
import java.lang.*;

class Deploy {
    private DeployConfig deployConfig;

    public Deploy(DeployConfig config) {
        deployConfig = config;
    }

    public void run() throws Exception {
        // get folder to save the deploy
        String deployPath = deployConfig.getConfigValue("deploy-path");
        String pathToProject = deployConfig.getConfigValue("path-to-project");
        String mainFolder = deployConfig.getConfigValue("main-folder");
        String projectName = deployConfig.getConfigValue("project-name");

        // validate deploy folder exists
        File deployPathFolder = new File( deployPath );
        if( !deployPathFolder.exists() || !deployPathFolder.isDirectory() ){
            System.out.println("config error!: deploy-path must be an existent folder");
            return;
        }

        // validate project folder exists
        File projectPath = new File( pathToProject + "/" + mainFolder );
        if( !projectPath.exists() || !projectPath.isDirectory() ){
            System.out.println("config error!: project-path must be an existent folder");
            return;
        }

        // validate project folder exists
        String version = deployConfig.getConfigValue("version");
        if( version == null ){
            System.out.println("config error!: you have to include a valid version.");
            return;
        }

        String compressedFileName = projectName + "-" + version;

        System.out.println(compressedFileName);

        compress( pathToProject, mainFolder, compressedFileName );
        moveCompressedFileToDeployPath( compressedFileName, deployPath );

        return;
    }

    public void compress( String pathToProject, String folderToCompress, String compressedFileName )
     throws Exception {
        String command = "tar -czvf "+ compressedFileName + ".tar.gz " + "-C " + pathToProject + 
            " " + folderToCompress;
        System.out.println(command);
        try {
            // Get runtime
            java.lang.Runtime rt = java.lang.Runtime.getRuntime();
            java.lang.Process p = rt.exec(command);
            p.waitFor();
            System.out.println("- "+ folderToCompress +" Folder Compressed.");

        } catch (IOException e) {
            // print errors
        }
    }

    public void moveCompressedFileToDeployPath( String compressedFileName, String deployPathFolder )
    throws Exception {
        String moveCommand = "mv " + compressedFileName + ".tar.gz " + deployPathFolder;
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        java.lang.Process p = rt.exec(moveCommand);
        p.waitFor();
        System.out.println("- File Moved to Deploy Folder.");

        return;
    }

}