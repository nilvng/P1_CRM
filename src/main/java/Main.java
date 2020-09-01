import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class Main {
    public static void main(String[] args) throws IOException {
        FileOperator.writeFile();
        LeadStorage lead = new LeadStorage();
        lead.fetchData();
    }
}
