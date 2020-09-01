import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        InteractionStorage is = null;
        try {
            is = new InteractionStorage();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
