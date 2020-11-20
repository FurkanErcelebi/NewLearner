package Learner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class source extends JFrame {
    JFrame f;

    source() {
        /*f=new JFrame();//creating instance of JFrame*/

        JButton b = new JButton("Yönlendir");//creating instance of JButton
        b.setBounds(130, 100, 100, 40);//x axis, y axis, width, height

        /*f*/
        add(b);//adding button in JFrame

        /*f*/
        setSize(300, 200);//400 width and 500 height
        /*f*/
        setLayout(null);//using no layout managers
        /*f*/
        setVisible(true);//making the frame visible
    }

    public static void main(String[] args) throws IOException, JSONException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        /*URL url=new URL("https://api.openweathermap.org/data/2.5/weather?q=İstanbul&appid=ec02339c8316ec0ec46fde632130b7eb");

        HttpURLConnection con= null;
        BufferedReader json = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            json = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        String inputLine = null,str="",name=null;
        double windsd = 0,temp = 0;
        int humid = 0,tm = 0;
        while (true) {
            try {
                if (!((inputLine = json.readLine()) != null)) break;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("\n"+inputLine);
            str=str+inputLine;
        }
        System.out.println(str);
        JSONObject obj = null;
        try {
            obj = new JSONObject(str);
            name=obj.getString("name");
            temp=obj.getJSONObject("main").getDouble("temp");
            windsd=obj.getJSONObject("wind").getDouble("speed");
            humid=obj.getJSONObject("main").getInt("humidity");
            tm=obj.getInt("dt");
            json.close();
        } catch (JSONException | IOException jsonException) {
            jsonException.printStackTrace();
        }
        Date gmtTime = new Date(tm);
        System.out.println("\n city:"+name
                +"\n"+"temperature: "+temp
                +"\n"+"wind speed: "+windsd
                +"\n"+"humidity :"+humid
                +"\n"+"date and time :"+gmtTime.toString());

        con.disconnect();*/

        //new source();
        CityAdder city = new CityAdder();
        city.Display();
    }
}
