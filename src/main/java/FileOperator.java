
import java.io.*;
import java.util.*;

public class FileOperator {

    public FileOperator() {
    }

    public static BufferedReader openFile(String fileName) throws FileNotFoundException {
        BufferedReader bfr = new BufferedReader(new FileReader(fileName));
        return bfr;
    }

    public static void writeFile(String filename) throws IOException{
        FileWriter csvWriter = new FileWriter(filename);
    }


    public void appendFile() {
        // TODO implement here
    }

}