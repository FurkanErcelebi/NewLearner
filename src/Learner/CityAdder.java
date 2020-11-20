package Learner;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

import org.json.JSONException;

public class CityAdder extends JFrame {
    JPanel panel;
    JButton add;
    JTextField city, country;
    JComboBox cty;
    JLabel countryname, background, city_name, temperature, windspeed, humidity;
    Toolkit tool;
    ImageIcon img;
    String cities[] = {"London", "Washington D.C.", "Vienna", "Baku", "Moscow", "Seoul", "İstanbul"};
    static Connection connection = null;
    static String databaseName = "";
    static String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;

    static String username = "root";
    static String password = "mxkl335%*#8EX6m37";
    static String databaseModel = "mydb";
    static String databasetable1 = "primarytable";
    static String databasetable2 = "secondarytable";

    public CityAdder() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        super("Mevsim İçin şehir seç");
        cty = new JComboBox(cities);
        city_name = new JLabel();
        temperature = new JLabel();
        windspeed = new JLabel();
        humidity = new JLabel();
        city_name.setBounds(200, 60, 200, 20);
        temperature.setBounds(200, 110, 200, 20);
        windspeed.setBounds(200, 140, 200, 20);
        humidity.setBounds(200, 170, 200, 20);
        cty.setBounds(50, 50, 90, 20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, username, password);

    }

    public void Display() throws IOException, JSONException {
        this.add(cty);
        //this.add(background);
        this.add(city_name);
        this.add(temperature);
        this.add(windspeed);
        this.add(humidity);
        /*
        img=new ImageIcon("Weather.jpg");
        background=new JLabel();
        background.setIcon(img);*/
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        cty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text, name = null;
                name = (String) cty.getItemAt(cty.getSelectedIndex());
                URL url = null;
                try {
                    url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=ec02339c8316ec0ec46fde632130b7eb");
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
                HttpURLConnection con = null;
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
                String inputLine = null, str = "", sql = "";
                double windsd = 0, temp = 0;
                int humid = 0, status = 0;
                while (true) {
                    try {
                        if (!((inputLine = json.readLine()) != null)) break;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    System.out.println("\n" + inputLine);
                    str = str + inputLine;
                }
                //System.out.println(str);
                JSONObject obj = null;
                try {
                    obj = new JSONObject(str);
                    name = obj.getString("name");
                    temp = obj.getJSONObject("main").getDouble("temp");
                    windsd = obj.getJSONObject("wind").getDouble("speed");
                    humid = obj.getJSONObject("main").getInt("humidity");
                    json.close();
                } catch (JSONException | IOException jsonException) {
                    jsonException.printStackTrace();
                }
                System.out.println("\n city:" + name
                        + "\n" + "temperature: " + temp
                        + "\n" + "wind speed: " + windsd
                        + "\n" + "humidity :" + humid);

                con.disconnect();

                text = "Seçilen şehir: " + cty.getItemAt(cty.getSelectedIndex());
                city_name.setText(text);
                text = "Sıcaklık: " + Double.toString(temp) + " K";
                temperature.setText(text);
                text = "Yağmur: " + Double.toString(windsd) + "%";
                windspeed.setText(text);
                text = "Nem: " + Double.toString(humid) + "%";
                humidity.setText(text);

                Statement statement = null;
                PreparedStatement ps = null;
                try {
                    // Birinci tabloda seçimdeki şehri içerip içermediği bakılır
                    statement = connection.createStatement();
                    ResultSet resset;
                    sql = "select city , id from "
                            + databaseModel + "."
                            + databasetable1 + " where city='"
                            + cty.getItemAt(cty.getSelectedIndex()) + "';";
                    resset = statement.executeQuery(sql);
                    if (resset.next()) {
                        // Seçilen şehirin olması sonrası ikinci tabloya özelliklerinin konulması
                        System.out.println(cty.getItemAt(cty.getSelectedIndex()) + " şehri var");
                        sql = "insert into " + databaseModel + "." + databasetable2 + " values ("
                                + Integer.toString(resset.getInt("id"))
                                + "," + Double.toString(windsd)
                                + "," + Double.toString(humid)
                                + "," + Double.toString(temp) + ")";

                        ps = connection.prepareStatement(sql);

                        status = ps.executeUpdate();

                        if (status != 0) {
                            System.out.println("Veri tabanına bağlandı");
                            System.out.println("Kayıt eklendi");
                        } else {
                            System.out.println("Veri Tabanına  bağlanılamadı");
                        }
                    } else {
                        //Seçilen şehir birincitabloya eklenmes
                        System.out.println(cty.getItemAt(cty.getSelectedIndex()) + " adında şehir yok");
                        sql = "insert into " + databaseModel + "." + databasetable1 + "(city) values ('" + cty.getItemAt(cty.getSelectedIndex()) + "');";
                        ps = connection.prepareStatement(sql);

                        status = ps.executeUpdate();

                        if (status != 0) {
                            System.out.println("Veri tabanına bağlandı");
                            System.out.println(cty.getItemAt(cty.getSelectedIndex()) + " Şehri eklendi");
                        } else {
                            System.out.println("Veri Tabanına  bağlanılamadı");
                        }

                        sql = "select id , city from "
                                + databaseModel + "."
                                + databasetable1 + " where city='"
                                + cty.getItemAt(cty.getSelectedIndex()) + "';";
                        resset = statement.executeQuery(sql);
                        if (!resset.next()) System.out.println("Sorgu için istanilen sıra bulunamamıştır");
                        System.out.println(resset.getInt("id"));
                        //Seçilen şehirin eklenmesi sonrası ikinci tabloya özelliklerinin konulması
                        sql = "insert into " + databaseModel + "." + databasetable2 + " values ("
                                + Integer.toString(resset.getInt("id"))
                                + "," + Double.toString(windsd)
                                + "," + Double.toString(humid)
                                + "," + Double.toString(temp) + ")";

                        ps = connection.prepareStatement(sql);

                        status = ps.executeUpdate();

                        if (status != 0) {
                            System.out.println("Veri tabanına bağlandı");
                            System.out.println("Kayıt eklendi");
                        } else {
                            System.out.println("Veri Tabanına  bağlanılamadı");
                        }
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
    }

}
