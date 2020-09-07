
import java.io.IOException;

public class InteractionCsvUtils extends CsvUtils<Interaction> {
    private static InteractionCsvUtils INSTANCE;

    static {
        try {
            INSTANCE = new InteractionCsvUtils();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InteractionCsvUtils() throws IOException {
        super("interactions.csv", Interaction.class);
    }

    public static InteractionCsvUtils getInstance(){
        return INSTANCE;
    }

}
