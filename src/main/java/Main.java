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
//        interactionManager.add();
//        interactionManager.viewAll();
        statsReport.menu();
    }

}

