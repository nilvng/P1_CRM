import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.util.*;
public class Lead{

    public Lead() {
    }
    @CsvBindByName
    private String id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private Boolean gender;
    @CsvBindByName
    @CsvDate("dd-MM-yyyy")
    private Date dob;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String phone;
    @CsvBindByName
    private String address;

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void generateId(int size){
        size ++;
        String prefix = "lead_";
        if ( size < 10){
            prefix += "00";
        } else
        if (size < 100){
            prefix += "0";
        }
        this.id = prefix + size;
    }
    public Lead deepCopy() {
        Lead lead = new Lead();
        lead.id = this.id; // privacy is per class. class can access all private field of instance
        lead.setAddress(this.address);
        lead.setDob(this.dob);
        lead.setEmail(this.email);
        lead.setName(this.name);
        lead.setPhone(this.phone);
        lead.setGender(this.gender);
        return lead;
    }



    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = (gender != null ? gender: this.gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (!name.equals("-") ? name: this.name);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = (dob != null ? dob: this.dob);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = (email.equals("-") ? email: this.email);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = (phone.equals("-") ? phone: this.phone);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = (address.equals("-") ? address: this.address);
    }


    public int getAge(){
        Date now = new Date();

        int days = (int)(( now.getTime() - this.dob.getTime())
                / (1000 * 60 * 60 * 24)) ;

        int age = (int)(days/365.25);
        return age;

    }


}