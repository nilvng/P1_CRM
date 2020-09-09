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
        interaction.setDate(Validator.enterDate("05-06-2020"));
        interaction.setLead("lead_007");
        interaction.setMeans("phone");
        interaction.setPotential("neutral");
    }
}
