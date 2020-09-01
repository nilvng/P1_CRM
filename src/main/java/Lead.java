
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.*;

/**
 * 
 */
public class Lead {

    public Lead() {
    }

    @CsvBindByName
    private String id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private Date dob;

//    @CsvBindByName
//    private boolean gender;

    @CsvBindByName
    private String email;

    @CsvBindByName
    private String phone;

    @CsvBindByName
    private String address;


}