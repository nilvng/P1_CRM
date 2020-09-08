
import java.io.IOException;
import java.util.*;

public class LeadService {

    private LeadManager leadManager;


    public LeadService() {
        this.leadManager = LeadManager.getInstance();
    }


    public void viewAll() {
        List<Lead> data = leadManager.getData();
        for (Lead i: data){
            System.out.println(i);
        }
    }

    public void add() throws IOException, NullPointerException {
        Lead lead = new Lead();
//        System.out.println("Enter info of new lead:");
//        Scanner console = new Scanner(System.in);
        // TODO ask for user input

        leadManager.add(lead);
    }

    public void update() throws IOException, NullPointerException {
        String id = enterId();
        int index = leadManager.findIndex(id);
        Lead lead = leadManager.findElement(id);
        if (lead != null && index != -1) {
            // TODO ask for user input
            
            leadManager.update(lead, index);
        } else {
            System.out.println("invalid id");
        }
    }

    public void delete() throws IOException, NullPointerException {
        String id = enterId();
        int index = leadManager.findIndex(id);

        if ( index != -1) {
            leadManager.delete(index);
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