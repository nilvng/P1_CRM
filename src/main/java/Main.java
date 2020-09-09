import java.io.IOException;


public class Main {
    public static void main(String[] args) throws Exception {
//        Manager<Interaction> interactionManager = InteractionManager.getInstance();
//        CsvUtils<Interaction> interactionCsvUtils = new CsvUtils<>(
//                "interactions.csv",
//                Interaction.class,
//                interactionManager);
//
//        interactionManager.viewAll();
//      Manager<Lead> leadManager = LeadManager.getInstance();
        Manager<Interaction> interactionManager = InteractionManager.getInstance();
        CsvUtils<Interaction> interactionCsvUtils = new CsvUtils<>("interactions.csv", Interaction.class, interactionManager);
//      CsvUtils<Lead> leadCsvUtils = new CsvUtils<Lead>("leads.csv", Lead.class, leadManager );
        StatsReport statsReport = new StatsReport();
//        statsReport.GroupAge(leadManager.getData());
//        interactionManager.viewAll();
//        statsReport.InteractionByPotential(interactionManager.getData());
          statsReport.InteractionByMonth(interactionManager.getData());
    }
}

