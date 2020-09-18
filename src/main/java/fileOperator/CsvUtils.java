package fileOperator;


import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import service.Savable;

import java.io.*;

import java.util.*;

public class CsvUtils<T> implements FileUtils {
    private String address;
    private Class<T> typeParameterClass;
    private Savable<T> manager;

    public CsvUtils(String address, Class<T> typeParameterClass, Savable<T> manager) throws IOException {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Class<T> getTypeParameterClass() {
        return typeParameterClass;
    }

    public void setTypeParameterClass(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public Savable<T> getManager() {
        return manager;
    }

    public void setManager(Savable<T> manager) {
        this.manager = manager;
    }
}