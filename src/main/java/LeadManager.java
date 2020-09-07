
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class LeadManager implements Manager {

    private LeadCsvUtils leadCsvUtils;

    public LeadManager() {
        this.leadCsvUtils = LeadCsvUtils.getInstance();
    }


    @Override
    public void viewAll() {
        List<Lead> data = leadCsvUtils.getData();
        for (Lead i: data){
            System.out.println(i);
        }
    }

    @Override
    public void add() throws IOException, NullPointerException {
        Lead lead = new Lead();
//        System.out.println("Enter info of new lead:");
//        Scanner console = new Scanner(System.in);
        // TODO ask for user input
//        lead.setDate(ValidateUserInput.enterDate("05-06-2020"));
//        lead.setLead("lead_007");
//        lead.setMeans("phone");
//        lead.setPotential("neutral");
//        lead.generateId(leadCsvUtils.getSize());

        leadCsvUtils.add(lead);
    }

    @Override
    public void update() throws IOException, NullPointerException {
        String id = enterId();
        int index = leadCsvUtils.findIndex(id);
        Lead lead = leadCsvUtils.findElement(id);
        if (lead != null && index != -1) {
            // TODO ask for user input
//            lead.setDate(ValidateUserInput.enterDate("27-06-2020"));
//            lead.setLead("lead_009");
//            lead.setMeans("Facebook");
//            lead.setPotential("neutral");

            leadCsvUtils.update(lead, index);
        } else {
            System.out.println("invalid id");
        }
    }

    @Override
    public void delete() throws IOException, NullPointerException {
        String id = enterId();
        int index = leadCsvUtils.findIndex(id);

        if ( index != -1) {
            leadCsvUtils.delete(index);
        } else {
            System.out.println("invalid id");
        }
    }

    private String enterId(){
        System.out.println("Enter item id: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


}