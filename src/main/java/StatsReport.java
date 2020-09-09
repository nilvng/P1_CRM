
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
        int trueSize = 0;
        for (int i = 0; i < interactions.size(); i++){
            Interaction inter = interactions.get(i);
            if (inter.getDate().after(DateArray[0]) && inter.getDate().before(DateArray[1])) {
                String extractMY = sdf.format(inter.getDate());
                dateString[i] = extractMY.substring(3, 10);
                trueSize++;
            }
        }
        int[] countArray = new int[trueSize];
        int visited = -1;
        for(int i = 0; i < trueSize; i++){
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
            String monthstr;
            monthstr = dateString[i].substring(0, 2);
            String YearExtract = dateString[i].substring(3);
            String MonthExtract = "";
            switch (monthstr){
                case "01":
                    MonthExtract = "Jan";
                    break;
                case "02":
                    MonthExtract = "Feb";
                    break;
                case "03":
                    MonthExtract = "Mar";
                    break;
                case "04":
                    MonthExtract = "Apr";
                    break;
                case "05":
                    MonthExtract = "May";
                    break;
                case "06":
                    MonthExtract = "Jun";
                    break;
                case "07":
                    MonthExtract = "Junl";
                    break;
                case "08":
                    MonthExtract = "Aug";
                    break;
                case "09":
                    MonthExtract = "Sep";
                    break;
                case "10":
                    MonthExtract = "Oct";
                    break;
                case "11":
                    MonthExtract = "Nov";
                    break;
                case "12":
                    MonthExtract = "Dec";
                    break;
            }
            if(countArray[i] != visited)
                System.out.println("    " + MonthExtract + " " + YearExtract + "    |    " + countArray[i]);
        }
    }

}