
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.*;

public class dataStore<T extends Searchable> {
    private List<T> data ;
    private final String address;
    public  Class<T> typeParameterClass;


    public dataStore(Class<T> typeParameterClass, String address) throws IOException {
        this.typeParameterClass = typeParameterClass;
        this.address = address;
        this.data = fetchData();
    }

    private List<T> fetchData()  throws IOException {
        return  new CsvToBeanBuilder<T>(new FileReader(address))
                .withType(typeParameterClass)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
    }

    private void pushData() throws IOException{
        try (Writer writer = new FileWriter(address))
        {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            beanToCsv.write(data);
        }
        catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    public void viewAll() {
        for (T i: data){
            System.out.println(i);
        }
    }

    public void add(T interaction) throws IOException {
        // TODO increment id
        this.data.add(interaction);
//        pushData();
    }

//    @Override
    public T update(String id) {
        return find(id);
    }

//    @Override
    public void delete(String id) {
        data.remove(find(id));
    }

    private T find(String id){
        for (T i: data){
            if (i.getId().contains(id)){
                return i;
            }
        }
        return null;
    }
}