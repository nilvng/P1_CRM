
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 */
public class FileOperator {

    /**
     * Default constructor
     */
    public FileOperator() {
    }



    /**
     *
     */
    public static Scanner openFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        return sc;
    }

    /**
     * 
     */
    public static void writeFile() {
        System.out.println("hello there");
    }

    /**
     * 
     */
    public void appendFile() {
        // TODO implement here
    }

}