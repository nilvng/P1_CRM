
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class LeadStorage implements Mange {

    /**
     * Default constructor
     */
    public LeadStorage() {
    }

    /**
     * 
     */
    private List<Lead> leads;

    /**
     * 
     */
    private String address = "leads.csv";



    /**
     * 
     */
    public void viewAll() {
        // TODO implement here
    }

    /**
     * 
     */
    public void add() {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void update(String id) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void delete(String id) {
        // TODO implement here
    }

    public void fetchData()  throws IOException {
        leads = new CsvToBeanBuilder<Lead>(new FileReader(address))
                .withType(Lead.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
        System.out.println("Done");
        System.out.println(leads.get(0));
    }

}