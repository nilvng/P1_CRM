import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
//        InteractionCsvUtils interactionCsvUtils = InteractionCsvUtils.getInstance();
//        InteractionCsvUtils interactionCsvUtils1 = InteractionCsvUtils.getInstance();
//        System.out.println(interactionCsvUtils);
//        System.out.println(interactionCsvUtils1);
        InteractionManager interactionManager = new InteractionManager();
        interactionManager.viewAll();
        System.out.println(Boolean.parseBoolean("-"));
//        System.out.println("after: ");
//        interactionManager.add();
//        interactionManager.delete();
//        interactionManager.update();
//        interactionManager.viewAll();

    }
}
