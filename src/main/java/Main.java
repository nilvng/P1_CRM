import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        InteractionStorage is = null;
        try {
            is = new InteractionStorage();
//            is.pushData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
