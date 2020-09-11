
import java.text.SimpleDateFormat;
import java.util.*;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Interaction{

    @CsvBindByName
    private String id;
    @CsvBindByName
    @CsvDate("yyyy-MM-dd")
    private Date date;
    @CsvBindByName
    private String lead;
    @CsvBindByName
    private String means;
    @CsvBindByName
    private String potential;

    private static List<String> validPotential = new ArrayList<>(Arrays.asList("positive","negative","neutral"));
    private static List<String> validMeans = new ArrayList<>(Arrays.asList("phone", "email", "Facebook"));



//    public String getInput(String mess, String validateRule, Scanner console){
//        boolean isInValid = false;
//        do {
//            System.out.println("Enter interaction's date:");
//            String input = console.nextLine();
//            try {
//                this.date = Validator.validateDate(date);
//            } catch (InvalidInputException e) {
//                System.out.println(e.getMessage());
//                isInValid = true;
//            }
//        } while (isInValid);
//    public void createObject(){
//
//        Interaction interaction = new Interaction();
//        interaction.setLead(getInput());
//
//    }
//
//        return input;
//    }
//

    public void createFromConsole(){
//        System.out.println("Create new interaction by following this format:");
//        System.out.println("[date];[lead];[means];[potential]");
//        String[] input = console.nextLine().split(";");
        Scanner console = new Scanner(System.in);
        boolean isInValid = false;

        do {
            isInValid = false;
            System.out.println("Enter id of the lead who participates in this interaction:");
            String id = console.nextLine();
            try {
                this.lead = Validator.validateLeadId(id);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                isInValid = true;
            }
        } while (isInValid);

        do {
            isInValid = false;
            System.out.println("Enter interaction's mean:");

            String means = console.nextLine();
            if (validMeans.contains(means.trim().toLowerCase())) {
                this.means = means;
            } else{
                isInValid = true;
                System.out.println();
            }
        } while (isInValid);

        do {
            isInValid = false;
            System.out.println("Enter interaction's potential:");

            String potential = console.nextLine();
            if (validPotential.contains(potential.trim().toLowerCase())) {
                this.potential = potential;
            } else{
                isInValid = true;
            }
        } while (isInValid);

//        this.date = Validator.enterDate(input[0]);
//        if (Validator.DoesLeadExist(input[1])) {
//            this.setLead(input[1]);
//        }
//        if (validMeans.contains(input[2].trim().toLowerCase())) {
//            this.setMeans(input[2]);
//        }
//        if (validPotential.contains(input[3].trim().toLowerCase())) {
//            this.setPotential(input[3]);
        }

    public void editFromConsole(){
        System.out.println("You will edit this interaction: ");
        System.out.println(this);
        System.out.println("Edit the interaction by following this format: (leave '-' if you don't want to change that field )");
        System.out.println("[date];[lead];[means];[potential]");

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

    public void generateId(int size) {
        size++;
        String prefix = "inter_";
        if (size < 10) {
            prefix += "00";
        } else if (size < 100) {
            prefix += "0";
        }
        this.id = prefix + size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
      // TODO double check input date
//        this.date = (date != null ? date: this.date);
        this.date = date;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
//        this.lead = !lead.equals("-") ? lead: this.lead;
        this.lead = lead;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
//        this.means = !means.equals("-") ? means: this.means;
            this.means = means;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
//        this.potential = !potential.equals("-") ? potential: this.potential;
            this.potential = potential;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Interaction{" +
                "id='" + id + '\'' +
                ", date=" + sdf.format(date) +
                ", lead='" + lead + '\'' +
                ", means='" + means + '\'' +
                ", potential='" + potential + '\'' +
                '}';
    }
}