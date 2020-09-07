import java.io.IOException;

public class LeadCsvUtils extends CsvUtils<Lead>{
    private static LeadCsvUtils INSTANCE;

    static {
        try {
            INSTANCE = new LeadCsvUtils();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LeadCsvUtils() throws IOException {
        super("leads.csv", Lead.class);
    }


    public static LeadCsvUtils getInstance(){
        return INSTANCE;
    }
}
