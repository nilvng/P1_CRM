import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InteractionService{
    private InteractionManager InteractionManager;

    public InteractionService() {
        this.InteractionManager = InteractionManager.getInstance();
    }


    public void viewAll() {
        List<Interaction> data = InteractionManager.getData();
        for (Interaction i: data){
            System.out.println(i);
        }
    }

    public void add() throws IOException, NullPointerException {
        Interaction interaction = new Interaction();
//        System.out.println("Enter info of new interaction:");
//        Scanner console = new Scanner(System.in);
        // TODO ask for user input
        interaction.setDate(ValidateUserInput.enterDate("05-06-2020"));
        interaction.setLead("lead_007");
        interaction.setMeans("phone");
        interaction.setPotential("neutral");
        interaction.generateId(InteractionManager.getSize());

        InteractionManager.add(interaction);
    }

    public void update() throws IOException, NullPointerException {
        String id = enterId();
        int index = InteractionManager.findIndex(id);
        Interaction interaction = InteractionManager.findElement(id);
        if (interaction != null && index != -1) {
            // TODO ask for user input
            interaction.setDate(ValidateUserInput.enterDate("27-06-2020"));
            interaction.setLead("lead_009");
            interaction.setMeans("Facebook");
            interaction.setPotential("neutral");
            System.out.println("after having updated given interaction");

            InteractionManager.update(interaction, index);
        } else {
            System.out.println("invalid id");
        }
    }

    public void delete() throws IOException, NullPointerException {
        String id = enterId();
        int index = InteractionManager.findIndex(id);

        if ( index != -1) {
            InteractionManager.delete(index);
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
