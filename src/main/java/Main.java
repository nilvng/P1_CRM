import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Manager<Interaction> interactionManager =  InteractionManager.getInstance();
        CsvUtils<Interaction> interactionCsvUtils = new CsvUtils<>(
                "interactions.csv",
                Interaction.class,
                interactionManager);

        interactionManager.viewAll();

//        InteractionManager interactionManager = new InteractionManager();
//        interactionManager.viewAll();
//        System.out.println("after: ");
//        interactionManager.add();
//        interactionManager.delete();
//        interactionManager.update();
//        interactionManager.viewAll();

    }
}
