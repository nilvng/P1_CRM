import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        StatsReport statsReport = new StatsReport();
        InteractionManager interactionManager = InteractionManager.getInstance();
        CsvUtils<Interaction> interactionCsvUtils = new CsvUtils(
                "interactions.csv",
                Interaction.class,
                InteractionManager.getInstance());

        Savable<Lead> leadManager = LeadManager.getInstance();
        CsvUtils<Lead> leadCsvUtils = new CsvUtils(
                "leads.csv",
                Lead.class,
                leadManager
        );
        System.out.println("Program begins!");
        Scanner console = new Scanner(System.in);
        String input;
        do {
            System.out.println("Primary functions:");
            System.out.println("A. Manager");
            System.out.println("B. Report");
            System.out.println("you can type 'end' to end the program");
            input = console.nextLine();
            switch (input){
                case "A":
                    Manager manager = null;
                    System.out.println("Which subject you want to manage?");
                    System.out.println("1. Interaction");
                    System.out.println("2. Lead");
                    input = console.nextLine();
                    switch (input) {
                        case "1":
                            manager = InteractionManager.getInstance();
                            break;
                        case "2":
                            manager = LeadManager.getInstance();
                            break;
                        default:
                            System.out.println("Fail to manage anything");
                    }
                    if (manager != null) management(console, manager);
                    break;
                case "B":
                    statsReport.menu(console);
                    break;
                default:
                    if (!input.equals("end")) {
                        System.out.println("Invalid input. Please only enter A or B");
                    }
            }
        } while (!input.equals("end"));
    }

    public static void management(Scanner console, Manager manager){
        String input;
        do {
            System.out.println("You have 4 options as an manager, please type from 1 to 4 ");
            System.out.println("1. view all");
            System.out.println("2. add");
            System.out.println("3. delete");
            System.out.println("4. update");
            System.out.println("you can type 'done' to back out");

            input = console.nextLine();
            switch (input){
                case "1":
                    manager.viewAll();
                    break;
                case "2":
                    manager.add();
                    break;
                case "3":
                    manager.delete();
                    break;
                case "4":
                    manager.update();
                    break;
                default:
                    if (!input.equals("done")) {
                        System.out.println("Invalid input. please only enter from 1 to 4");
                    }
            }
            } while (!input.equals("done"));
        }

}

