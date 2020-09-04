import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        dataStore<Interaction> interactiondataStore = new dataStore<>(Interaction.class, "interactions.csv");
        interactiondataStore.viewAll();
    }
}
