
import java.util.*;

public class LeadView {

    public LeadView() {
    }

    public String enterId(){
        System.out.println("Enter item id: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void enterLead(Lead lead){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lead's name: ");
        lead.setName(sc.nextLine());
        System.out.println("Enter lead's gender: (True for Woman, False for Man)");
        lead.setGender(sc.nextBoolean());
        System.out.println("Enter lead's phone: ");
        lead.setPhone(sc.nextLine());
        System.out.println("Enter lead's email: ");
        lead.setEmail(sc.nextLine());
        System.out.println("Enter lead's dob: ");
//        lead.setDob(Validator.enterDate(sc.nextLine()));
        System.out.println("Enter lead's address: ");
        lead.setAddress(sc.nextLine());
    }
}