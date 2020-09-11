import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Manager interactionManager = InteractionManager.getInstance();
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
        interactionManager.add();
        interactionManager.viewAll();
//        StatsReport statsReport = new StatsReport();
//
//        Scanner console = new Scanner(System.in);
//        System.out.println("the program begins!");
//
//        System.out.println("  hello bayesian ".trim());

//        System.out.println("Report options:");
//        System.out.println("1. Reporting Lead by group age");
//        System.out.println("2. Reporting interactions by month");
//        System.out.println("3. Reporting interaction by potential");
//        System.out.println("Enter your choice (from 1 to 3):");
//        String answer = console.nextLine();
//        switch (answer) {
//            case "1":
//                statsReport.GroupAge(leadManager.getData());
//                break;
//            case "2":
//                statsReport.InteractionByPotential(interactionManager.getData());
//                break;
//            case "3":
//                statsReport.InteractionByMonth(interactionManager.getData());
//                break;
//            default:
//                System.out.println("Invalid option");
//                break;
//        }

    }

}

