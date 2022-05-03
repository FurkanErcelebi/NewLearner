package JSONExample;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonNodeArrayExample {

    public static void main(String[] args) throws JSONException ,JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<StuentOne> stuentOnes = new ArrayList<>();
        stuentOnes.add(new StuentOne(1, "Arthur"));
        stuentOnes.add(new StuentOne(2, "John"));
        stuentOnes.add(new StuentOne(3, "Emily"));
        TestList nList = new TestList();
        nList.setStuentOnes(stuentOnes);

        JSONObject jsonObject = new JSONObject(nList);

        for(int i = 0; i < jsonObject.getJSONArray("stuentOnes").length();i++){

            JSONObject oJsonObject = jsonObject.getJSONArray("stuentOnes").getJSONObject(i);
            System.out.println("Student no and name: " + oJsonObject.getInt("id") + "," + oJsonObject.getString("name"));

        }

    }

}
