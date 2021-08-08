package JSONExample;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import JSONExample.Name;
import JSONExample.Student;

public class JacksonTester {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<Name> names = null;
            Student student = new Student(1,3,"systemId1",names);

            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

