
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.*;


public class Lead {
    /*
    public Lead(String id, String name, Date dob, boolean gender, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    */

    @CsvBindByName
    private String id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private Date dob;
    @CsvBindByName
    private boolean gender;
    @CsvBindByName
    private String phone;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}