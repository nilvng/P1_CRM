
import java.util.*;

public class Interaction {


    public Interaction(String id, String lead, String means, String potential) {
        this.id = id;
        this.lead = lead;
        this.means = means;
        this.potential = potential;
    }

    private final String id;

    private Date date;

    private String lead;

    private String means;

    private String potential;

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }
}