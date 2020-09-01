
import java.io.*;
import java.util.*;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class InteractionStorage implements Mange {
    private List<Interaction> interactions ;
    private final String address = "interactions.csv";


    public InteractionStorage() throws IOException {
        fetchData();
        System.out.println("fetch done");
    }

    public void fetchData()  throws IOException {
        interactions = new CsvToBeanBuilder<Interaction>(new FileReader(address))
                .withType(Interaction.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
    }

    public void pushData() throws IOException{
        Writer writer = new FileWriter(address);
        StatefulBeanToCsv<Interaction> beanToCsv = new StatefulBeanToCsvBuilder<Interaction>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
        try {
            beanToCsv.write(this.interactions);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
        writer.close();
    }

    public void viewAll() {
        for (Interaction i: interactions){
            System.out.println(i);
        }


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