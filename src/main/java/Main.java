import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class Main {
    public static void main(String[] args){
        LeadStorage ls = null;
        try {
            ls = new LeadStorage();
            ls.viewAll();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
