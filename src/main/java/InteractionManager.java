import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InteractionManager implements Manager{
    private InteractionCsvUtils interactionCsvUtils;

    public InteractionManager() {
        this.interactionCsvUtils = InteractionCsvUtils.getInstance();
    }


    @Override
    public void viewAll() {
        List<Interaction> data = interactionCsvUtils.getData();
        for (Interaction i: data){
            System.out.println(i);
        }
    }

    @Override
    public void add() throws IOException, NullPointerException {
        Interaction interaction = new Interaction();
//        System.out.println("Enter info of new interaction:");
//        Scanner console = new Scanner(System.in);
        // TODO ask for user input
        interaction.setDate(ValidateUserInput.enterDate("05-06-2020"));
        interaction.setLead("lead_007");
        interaction.setMeans("phone");
        interaction.setPotential("neutral");
        interaction.generateId(interactionCsvUtils.getSize());

        interactionCsvUtils.add(interaction);
    }

    @Override
    public void update() throws IOException, NullPointerException {
        String id = enterId();
        int index = interactionCsvUtils.findIndex(id);
        Interaction interaction = interactionCsvUtils.findElement(id);
        if (interaction != null && index != -1) {
            // TODO ask for user input
            interaction.setDate(ValidateUserInput.enterDate("27-06-2020"));
            interaction.setLead("lead_009");
            interaction.setMeans("Facebook");
            interaction.setPotential("neutral");
            System.out.println("after having updated given interaction");

            interactionCsvUtils.update(interaction, index);
        } else {
            System.out.println("invalid id");
        }
    }

    @Override
    public void delete() throws IOException, NullPointerException {
        String id = enterId();
        int index = interactionCsvUtils.findIndex(id);

        if ( index != -1) {
            interactionCsvUtils.delete(index);
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
