
import java.text.SimpleDateFormat;
import java.util.*;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Interaction implements Searchable<Interaction>{

    @CsvBindByName
    private String id;
    @CsvBindByName
    @CsvDate ("dd-MM-yyyy")
    private Date date;
    @CsvBindByName
    private String lead;
    @CsvBindByName
    private String means;
    @CsvBindByName
    private String potential;

    public Interaction(){}

    public Interaction(String[] input){
        this.lead = input[0];
        this.means = input[1];
        this.potential = input[2];
    }

    public Interaction deepCopy(){
        Interaction that = new Interaction();
        that.id = this.id;
        that.date = this.date;
        that.lead = this.lead;
        that.means = this.means;
        that.potential = this.potential;
        return that;
    }

    public String getId() {
        return id;
    }

    public void generateId(int size){
        size ++;
        String prefix = "inter_";
        if ( size < 10){
            prefix += "00";
        } else
            if (size < 100){
            prefix += "0";
        }
        this.id = prefix + size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        // TODO double check input date
        this.date = (date != null ? date: this.date);
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = !lead.equals("-") ? lead: this.lead;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = !means.equals("-") ? means: this.means;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = !potential.equals("-") ? potential: this.potential;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Interaction{" +
                "id='" + id + '\'' +
                ", date=" + (date != null? sdf.format(date): "") +
                ", lead='" + lead + '\'' +
                ", means='" + means + '\'' +
                ", potential='" + potential + '\'' +
                '}';
    }
}