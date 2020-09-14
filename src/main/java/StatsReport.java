import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
public class StatsReport {

    public StatsReport() {
    }

    public void menu(Scanner console){
        InteractionManager interactionManager= InteractionManager.getInstance();
        LeadManager leadManager = LeadManager.getInstance();
        System.out.println("*************************************");
        System.out.println("Report options:");
        System.out.println("1. Reporting Lead by group age");
        System.out.println("2. Reporting interactions by month");
        System.out.println("3. Reporting interaction by potential");
        System.out.println("*************************************");
        System.out.println("Enter your choice (from 1 to 3):");
        String answer = console.nextLine();
        switch (answer) {
            case "1":
                this.GroupAge(leadManager.getData());
                break;
            case "2":
                this.InteractionByMonth(interactionManager.getData());
                break;
            case "3":
                this.InteractionByPotential(interactionManager.getData());
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void GroupAge(List<Lead> leads){
        int group1 = 0; //0-10
        int group2 = 0; //10-20
        int group3 = 0; //20-60
        int group4 = 0; //60+
        for (int i = 0; i < 10; i++){
            System.out.println(" Person " + (i + 1) + " : " + leads.get(i).getAge());
        }

        for (int i = 0; i < leads.size(); i++){
            if(leads.get(i).getAge() <= 10){
                group1++;
            } else if(leads.get(i).getAge() > 10 && leads.get(i).getAge() <= 20){
                group2++;
            } else if(leads.get(i).getAge() > 20 && leads.get(i).getAge() <= 60){
                group3++;
            } else if (leads.get(i).getAge() > 60){
                group4++;
            }
        }

        System.out.println("Group <= 10: " + group1);
        System.out.println("Group 10-20: " + group2);
        System.out.println("Group 20-60: " + group3);
        System.out.println("Group 60+: " + group4);
    }

    public Date[] inputStartEndDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the beginning date: ");
        String bDate = input.nextLine();
        Date startDate = null;
        try {
            startDate = sdf.parse(bDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Enter the ending date: ");
        String eDate = input.nextLine();
        Date endDate = null;
        try {
            endDate = sdf.parse(eDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date[] dateArray =  {startDate, endDate};
        return dateArray;
    }

    public void InteractionByPotential(List<Interaction> interactions){
        Date[] DateArray = inputStartEndDate();
        int positiveCount = 0;
        int negativeCount = 0;
        int neutralCount = 0;
        for (Interaction interaction : interactions) {
            if (interaction.getDate().after(DateArray[0]) && interaction.getDate().before(DateArray[1])) {
                switch (interaction.getPotential()) {
                    case "positive":
                        positiveCount++;
                        break;
                    case "negative":
                        negativeCount++;
                        break;
                    case "neutral":
                        neutralCount++;
                        break;
                }
            }
        }
        System.out.println("Positive potential: " + positiveCount);
        System.out.println("Negative potential: " + negativeCount);
        System.out.println("Neutral potential: " + neutralCount);
    }


    public void InteractionByMonth(List<Interaction> interactions){
        Date[] DateArray = inputStartEndDate();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        String[] dateString = new String[interactions.size()];
        int trueSize = 0;
        for (Interaction interaction : interactions) {
            Date date = interaction.getDate();
            if (date.after(DateArray[0]) && date.before(DateArray[1])) {
                dateString[trueSize]  = sdf.format(date);
                trueSize++;
            }
        }

        int[] countArray = new int[trueSize];
        int visited = -1;
        for(int i = 0; i < trueSize-1; i++){
            int count = 1;
            for(int j = i+1; j < trueSize -1; j++){
                if(dateString[i].equals(dateString[j])){
                    count++;
                    countArray[j] = visited;
                }
            }
            if(countArray[i] != visited)
                countArray[i] = count;
        }

        for(int i = 0; i < trueSize - 1; i++){
            if(countArray[i] != visited)
                System.out.println("    " + dateString[i] + "    |    " + countArray[i]);
        }
    }

}