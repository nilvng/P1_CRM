import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
public class StatsReport {
    public StatsReport() {
    }

    public void GroupAge() throws IOException{
        LeadManager leadManager = new LeadManager();
        int group1 = 0; //0-10
        int group2 = 0; //10-20
        int group3 = 0; //20-60
        int group4 = 0; //60+
        for (int i = 0; i < 10; i++){
            System.out.println(" Person " + (i + 1) + " : " + leadManager.leads.get(i).getAge());
        }

        for (int i = 0; i < 10; i++){
            if(leadManager.leads.get(i).getAge() <= 10){
                group1++;
            } else if(leadManager.leads.get(i).getAge() > 10 && leadManager.leads.get(i).getAge() <= 20){
                group2++;
            } else if(leadManager.leads.get(i).getAge() > 20 && leadManager.leads.get(i).getAge() <= 60){
                group3++;
            } else if (leadManager.leads.get(i).getAge() > 60){
                group4++;
            }
        }

        System.out.println("Group <= 10: " + group1);
        System.out.println("Group 10-20: " + group2);
        System.out.println("Group 20-60: " + group3);
        System.out.println("Group 60+: " + group4);
    }


    public void InteractionByPotential() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date Date1 = sdf.parse("30/07/2020");
        Date Date2 = sdf.parse("01/09/2020");
        Date Date3 = sdf.parse("05/09/2020");
        Interaction inter1 = new Interaction("inter_001", Date1, "lead_001", "email", "positive");
        Interaction inter2 = new Interaction("inter_002", Date2, "lead_002", "email", "positive");
        Interaction inter3 = new Interaction("inter_003", Date3, "lead_003", "phone", "neutral");
        List<Interaction> interactions = new ArrayList<Interaction>();
        interactions.add(0, inter1);
        interactions.add(1, inter2);
        interactions.add(2, inter3);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the beginning date: ");
        String bDate = input.next();
        Date startDate = sdf.parse(bDate);
        System.out.print("Enter the ending date: ");
        String eDate = input.next();
        Date endDate = sdf.parse(eDate);
        int positiveCount = 0;
        int negativeCount = 0;
        int neutralCount = 0;
        for (int i = 0; i < 3; i++){
            if (interactions.get(i).getDate().after(startDate) && interactions.get(i).getDate().before(endDate)){
                if (interactions.get(i).getPotential() == "positive"){
                    positiveCount++;
                } else if (interactions.get(i).getPotential() == "negative"){
                    negativeCount++;
                } else if(interactions.get(i).getPotential() == "neutral"){
                    neutralCount++;
                }
            }
        }
        System.out.println("Positive potential: " + positiveCount);
        System.out.println("Negative potential: " + negativeCount);
        System.out.println("Neutral potential: " + neutralCount);
    }


    public void InteractionByMonth() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date Date1 = sdf.parse("30/07/2020");
        Date Date2 = sdf.parse("01/09/2020");
        Date Date3 = sdf.parse("05/09/2020");
        Date Date4 = sdf.parse("05/06/2020");
        Interaction inter1 = new Interaction("inter_001", Date1, "lead_001", "email", "positive");
        Interaction inter2 = new Interaction("inter_002", Date2, "lead_002", "email", "positive");
        Interaction inter3 = new Interaction("inter_003", Date3, "lead_003", "phone", "neutral");
        Interaction inter4 = new Interaction("inter_004", Date4, "lead_004", "Facebook", "neutral");
        List<Interaction> interactions = new ArrayList<Interaction>();
        interactions.add(0, inter1);
        interactions.add(1, inter2);
        interactions.add(2, inter3);
        interactions.add(3, inter4);

        String[] dateString = new String[4];
        for (int i = 0; i < dateString.length; i++){
            String extractMY = sdf.format(interactions.get(i).getDate());
            dateString[i] = extractMY.substring(3, 10);
        }
        int[] countArray = new int[dateString.length];
        int visited = -1;
        for(int i = 0; i < dateString.length; i++){
            int count = 1;
            for(int j = i+1; j < dateString.length; j++){
                if(dateString[i].equals(dateString[j])){
                    count++;
                    countArray[j] = visited;
                }
            }
            if(countArray[i] != visited)
                countArray[i] = count;
        }

        for(int i = 0; i < countArray.length; i++){
            if(countArray[i] != visited)
                System.out.println("    " + dateString[i] + "    |    " + countArray[i]);
        }
    }

}