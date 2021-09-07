package ThreadAndProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuildig {
    
    public static void main(String[] args) {
        
        Path currentRelativePath = Paths.get("");
        String relativePath = currentRelativePath.toAbsolutePath().toString() + "/src/ThreadAndProcess";

        try{
            
             /*List<String> commands = new ArrayList<>();
            commands.add("cmd");
            commands.add("dir");
            commands.add("/b");
            commands.add("FOR");
            commands.add("/R");
            commands.add("%F");
            commands.add("in");
            commands.add("(*.txt)");
            commands.add("do");
            commands.add("echo");
            commands.add("%~nF");
            ProcessBuilder processBuilder = new ProcessBuilder(commands); 
            
            Process process = processBuilder.start();
 
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }*/

            ProcessBuilder processBuilder = new ProcessBuilder("cmd");
            
            File commands = new File(relativePath + "/testcmd.cmd");
             
            File error = new File(relativePath + "/error.txt");
            
            File output = new File(relativePath + "/output.txt");
            

            processBuilder.redirectInput(commands);
            processBuilder.redirectError(error);
            processBuilder.redirectOutput(output); 

            processBuilder.start();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
