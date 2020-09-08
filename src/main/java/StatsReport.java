
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

    public void GroupAge(List<Lead> leads) throws IOException{
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

    public Date[] inputStartEndDate() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the beginning date: ");
        String bDate = input.next();
        Date startDate = sdf.parse(bDate);
        System.out.print("Enter the ending date: ");
        String eDate = input.next();
        Date endDate = sdf.parse(eDate);
        Date[] dateArray =  {startDate, endDate};
        return dateArray;
    }

    public void InteractionByPotential(List<Interaction> interactions) throws Exception{
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


    public void InteractionByMonth(List<Interaction> interactions) throws ParseException{
        Date[] DateArray = inputStartEndDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String[] dateString = new String[interactions.size()];
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