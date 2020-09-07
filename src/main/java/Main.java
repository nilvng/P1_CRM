import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class Main{
    public static void main(String[] args) {
        try{
            StatsReport st = new StatsReport();
            st.InteractionByMonth();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
