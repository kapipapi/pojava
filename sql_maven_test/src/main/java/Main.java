import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Record> currencies_info = new ArrayList<Record>();

        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapo","java_test","test123");
            Statement statement = conn.createStatement();
            ResultSet result;

            result = statement.executeQuery("SELECT * FROM waluty");
            while (result.next()) {
                currencies_info.add(new Record(result));
            }

            CurrencyChart waluty = new CurrencyChart("waluty", currencies_info);
            waluty.setSize(1000,400);
            waluty.setVisible(true);

            conn.close();
        } catch (SQLException e) {
            System.err.println("Connection error: " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
