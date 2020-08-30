
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class InteractionStorage implements Mange {


    public InteractionStorage() {
    }

    private ArrayList<Interaction> interactions ;

    private final String address = "interactions.csv";

    public void updateData(){
        try {
            BufferedReader readFile = FileOperator.openFile(address);
            String row;
            while ((row = readFile.readLine()) != null){
                String[] token = row.split(",");
                Interaction interaction = new Interaction(token[0], token[2], token[3], token[4]);
                interactions.add(interaction);
                readFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAll() {
        // TODO implement here

    }

    public void add() {
        // TODO: increase id
    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

}