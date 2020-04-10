import org.jfree.data.time.Day;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Record {

    Day date;
    float USD, EUR, GBP;

    public Record(ResultSet result) {
        try {
            String[] tmp = result.getString("data").split("-");
            date = new Day(Integer.parseInt(tmp[2]),Integer.parseInt(tmp[1]),Integer.parseInt(tmp[0]));
            USD = result.getFloat("USD");
            EUR = result.getFloat("EUR");
            GBP = result.getFloat("GBP");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void show() {}

}
