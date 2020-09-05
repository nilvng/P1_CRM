import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InteractionManager implements Manager{
    private final String address = "interactions.csv";
    private final CsvUtils<Interaction> interactionCsvUtils;
    public InteractionManager() throws IOException {
        this.interactionCsvUtils = new CsvUtils<>(Interaction.class, address);
    }

    @Override
    public void viewAll() {
        List<Interaction> data = interactionCsvUtils.getData();
        for (Interaction i: data){
            System.out.println(i);
        }
    }

    @Override
    public void add() throws IOException {
        Interaction interaction = new Interaction();
//        System.out.println("Enter info of new interaction:");
//        Scanner console = new Scanner(System.in);
        interaction.setDate(ValidateUserInput.enterDate("05-06-2020"));
        interaction.setLead("lead_004");
        interaction.setMeans("phone");
        interaction.setPotential("neutral");
        interaction.generateId(interactionCsvUtils.getSize());
//        System.out.println(interaction);
        // TODO call setter method
        interactionCsvUtils.add(interaction);
    }

    @Override
    public void update() throws IOException {
        String id = enterId();
        Interaction interaction = interactionCsvUtils.findElement(id);
        int index = interactionCsvUtils.findOrder(id);
        if (interaction != null && index != -1) {
            // TODO call setter method
            interactionCsvUtils.update(interaction, index);
        } else {
            System.out.println("invalid id");
        }
    }

    @Override
    public void delete() throws IOException {
        String id = enterId();
        int index = interactionCsvUtils.findOrder(id);

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
