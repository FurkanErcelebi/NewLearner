package FİleIOExamples;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class EnvorimentVariables {

    public static void main(String[] args){

        /*Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }*/
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);
        StringBuilder regex = new StringBuilder();
        regex.append("\\");
        regex.append(File.separator);
        String[] s_parts = s.split(regex.toString());
        System.out.println("Path parts:");
        for (int i = 0; i < s_parts.length; i++) {
            System.out.println("s_parts[" + i + "]:" + s_parts[i]);
        }

    }

}
