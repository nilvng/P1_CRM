package service;

import domain.Interaction;
import domain.Lead;
import util.HandleInput;

import java.util.Date;
import java.text.SimpleDateFormat;
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
        System.out.println("-----");
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

        for (Lead lead : leads) {
            if (lead.getAge() <= 10) {
                group1++;
            } else if (lead.getAge() > 10 && lead.getAge() <= 20) {
                group2++;
            } else if (lead.getAge() > 20 && lead.getAge() <= 60) {
                group3++;
            } else if (lead.getAge() > 60) {
                group4++;
            }
        }

        System.out.println("Group <= 10: " + group1);
        System.out.println("Group 10-20: " + group2);
        System.out.println("Group 20-60: " + group3);
        System.out.println("Group 60+: " + group4);
    }

    public void InteractionByPotential(List<Interaction> interactions){
        Date[] dates = this.enterStartEndDate();
        Date startDate = dates[0];
        Date endDate = dates[1];
        int positiveCount = 0;
        int negativeCount = 0;
        int neutralCount = 0;
        for (Interaction interaction : interactions) {
            if (interaction.getDate().after(startDate) && interaction.getDate().before(endDate)) {
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
        Date[] dates = this.enterStartEndDate();
        Date startDate = dates[0];
        Date endDate = dates[1];
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        String[] dateString = new String[interactions.size()];
        int trueSize = 0;
        for (Interaction interaction : interactions) {
            Date date = interaction.getDate();
            if (date.after(startDate) && date.before(endDate)) {
                dateString[trueSize]  = sdf.format(date);
                trueSize++;
            }
        }
        int[] countArray = new int[trueSize];
        int visited = -1;
        for(int i = 0; i < trueSize-1; i++){
            int count = 1;
            for(int j = i+1; j < trueSize; j++){
                if(dateString[i].equals(dateString[j])){
                    count++;
                    countArray[j] = visited;
                }
            }
            if(countArray[i] != visited)
                countArray[i] = count;
        }
        System.out.println("Result: ");
        for(int i = 0; i < trueSize - 1; i++){
            if(countArray[i] != visited)
                System.out.println("\t" + dateString[i] + "\t|\t" + countArray[i]);
        }
    }

    public Date[] enterStartEndDate(){
        boolean isInvalid;
        Date startDate;
        Date endDate;
        do {
            isInvalid = false;
            HandleInput handler= new HandleInput();
            startDate = handler.enterDate("start date ", false);
            endDate = handler.enterDate("end date", false);
            if (startDate.after(endDate)){
                isInvalid = true;
                System.out.println("start date must be before the end date");
            }
        } while (isInvalid);
        return new Date[]{startDate, endDate};
    }

}
