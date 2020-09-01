
import java.io.*;
import java.util.*;
import com.opencsv.bean.CsvToBeanBuilder;

public class InteractionStorage implements Mange {
    private List<Interaction> interactions ;
    private final String address = "interactions.csv";


    public InteractionStorage() throws IOException {
        fetchData();
        System.out.println("fetch done");
    }

    public void fetchData()  throws IOException {
        interactions = new CsvToBeanBuilder<Interaction>(new FileReader(address))
                .withType(Interaction.class).build().parse();
//        System.out.println(interactions.get(0).getId());
//        System.out.println(interactions.get(1).getLead());
//        System.out.println(interactions.get(1).getDate());

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