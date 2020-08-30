
import java.io.*;
import java.util.*;

/**
 * 
 */
public class FileOperator {

    private FileOperator() {
    }

    public static BufferedReader openFile(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName));
    }

    public static void writeFile(String fileName) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName);

    }

    public static void appendFile() {
        // TODO implement here
    }

}