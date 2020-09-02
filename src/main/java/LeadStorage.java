import java.util.*;
import java.io.*;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileReader;
import java.io.IOException;


public class LeadStorage implements Mange {
    private List<Lead> leads;
    private final String address = "leads.csv";

    public LeadStorage() throws IOException{
        fetchData();
        System.out.println("fetch done");
    }
    public void fetchData()  throws IOException {
        leads = new CsvToBeanBuilder<Lead>(new FileReader(address))
                .withType(Lead.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
        System.out.println("Done");
    }

    public void viewAll() {
        for (Lead i: leads){
            System.out.println(i);
        }
    }


    public void add() {
        // TODO implement here
    }

    public void update(String id) {
        // TODO implement here
    }

    public void delete(String id) {
        // TODO implement here
    }



}