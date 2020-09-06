import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        InteractionManager interactionManager = new InteractionManager();
//        interactionManager.viewAll();
//        System.out.println("after: ");
//        interactionManager.add();
//        interactionManager.delete();
        interactionManager.update();
        interactionManager.viewAll();

    }
}
