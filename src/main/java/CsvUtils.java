
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.*;

public class CsvUtils<T extends Searchable> {
    private String address;
    private Class<T> typeParameterClass;
    private List<T> data;


    CsvUtils(Class<T> typeParameterClass, String address) throws IOException {
        if (address.length() > 4 && address.endsWith(".csv")) {
            this.typeParameterClass = typeParameterClass;
            this.address = address;
            fetchData();
        } else {
            // TODO incorrect address
            System.out.println("incorrect address");
        }
    }

    void fetchData() throws IOException {
        this.data = new CsvToBeanBuilder<T>(new FileReader(address))
                .withType(typeParameterClass)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
    }

    void saveData() throws IOException {
        try (Writer writer = new FileWriter(address)) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            beanToCsv.write(data);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    public List<T> getData() {
        // TODO deep copy?
        return data;
    }

    public void add(T t) throws IOException {
        data.add(t);
        saveData();
    }

    public void delete(int i) throws IOException {
        data.remove(i);
        saveData();
    }

    public void update(T t, int i) throws IOException {
        data.set(i, t);
        saveData();
    }

    public T findElement(String id) {
        // TODO return copy of the real object
        for (T i : data) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public int findOrder(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize(){
        return data.size();
    }
}