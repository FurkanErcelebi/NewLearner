package DataBaseTest;

import java.sql.*;

public class DataBaseExample {
    static Connection connection = null;
    static String databaseName = "";
    static String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;

    static String username = "root";
    static String password = "mxkl335%*#8EX6m37";
    static String databaseModel = "mydb";
    static String databasetable1 = "primarytable";
    static String databasetable2 = "secondarytable";

    static public void main(String[] args) throws InstantiationError, IllegalAccessException, ClassNotFoundException, SQLException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        ResultSet resset = statement.executeQuery("select city from " + databaseModel + "." + databasetable1 + " where city='Londra';");
        if (resset.next()) {
            System.out.println("Londra şehri var");
            String sql = "insert into " + databaseModel + "." + databasetable2 + " values (210.21,6.23,34.82,'İstanbul');";
            PreparedStatement ps = connection.prepareStatement(sql);

            int status = ps.executeUpdate();

            if (status != 0) {
                System.out.println("Veri tabanına bağlandı");
                System.out.println("Kayıt eklendi");
            } else {
                System.out.println("Veri Tabanına  bağlanılamadı");
            }
        } else {
            System.out.println("Londra adında şehir yok");
            String sql = "insert into " + databaseModel + "." + databasetable1 + "(city) values ('Londra');";
            PreparedStatement ps = connection.prepareStatement(sql);

            int status = ps.executeUpdate();

            if (status != 0) {
                System.out.println("Veri tabanına bağlandı");
                System.out.println("Londra Şehri eklendi");
            } else {
                System.out.println("Veri Tabanına  bağlanılamadı");
            }
        }
    }

}