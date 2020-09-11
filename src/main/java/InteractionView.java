import java.util.Scanner;

public class InteractionView {

    public InteractionView() {
    }

    public String enterId(){
        System.out.println("Enter item id: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void enterInteraction(Interaction interaction){
        System.out.println("Enter interaction's date:");
//        interaction.setDate(Validator.enterDate("05-06-2020"));
        System.out.println("Enter id of the lead who participates in this interaction:");
        interaction.setLead("lead_007");
        System.out.println("Enter interaction's mean:");
        interaction.setMeans("phone");
        System.out.println("Enter interaction's potential:");
        interaction.setPotential("neutral");
    }
}
