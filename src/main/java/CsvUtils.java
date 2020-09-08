
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.*;

public class CsvUtils<T> implements FileUtils<T>{
    private final String address;
    private final Class<T> typeParameterClass;
    private final Manager<T> manager;

    CsvUtils(String address, Class<T> typeParameterClass, Manager<T> manager) throws IOException {
        this.address = address;
        this.typeParameterClass = typeParameterClass;
        this.manager = manager;
        manager.setFileUtils(this);
    }

    public void fetchData() throws IOException {
        List<T> data = new CsvToBeanBuilder<T>(new FileReader(address))
                .withType(typeParameterClass)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
        manager.setData(data);
    }

    public void saveData() throws IOException {
        List<T> data = manager.getData();
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

}