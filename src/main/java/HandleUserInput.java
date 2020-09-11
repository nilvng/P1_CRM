import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HandleUserInput {
    private Scanner console = new Scanner(System.in);
    boolean isInvalid;
    String input;

    public HandleUserInput(){}

    public String getInput(String message, boolean leaveBlank){
        boolean isInvalid;
        do {
            isInvalid = false;
            System.out.println("Enter " + message);
            input = console.nextLine();
            if(input.equals("") && !leaveBlank){
                isInvalid = true;
            }
        } while (isInvalid);
        return input;
    }

    public String enterString(String message, boolean leaveBlank){
        do {
            isInvalid = false;
            input = getInput(message,leaveBlank);
        } while (isInvalid);
        return input;
    }

    public String enterSpecificString(String message, List<String> specificInput, boolean leaveBlank){
        do {
            isInvalid = false;
            input = getInput(message,leaveBlank);
            if(input.equals("") && leaveBlank) {
                break;
            }
                if (!specificInput.contains(input)){
                isInvalid = true;
            }
        } while (isInvalid);
        return input;
    }

    public Date enterDate(String message, boolean leaveBlank){
        Date dateInput = null;
        do {
            isInvalid = false;
            input = getInput(message,leaveBlank);
            if(input.equals("") && leaveBlank) {
                break;
            }
            try {
                dateInput  = new SimpleDateFormat("yyyy-MM-dd").parse(input);
            } catch (ParseException e) {
                isInvalid = true;
            }
        } while (isInvalid);
        return dateInput;
    }

    public String enterLeadId(String message, boolean leaveBlank){
        LeadManager leadManager = LeadManager.getInstance();
        String id;
        do {
            isInvalid = false;
            id = getInput(message,leaveBlank);
            if(input.equals("") && leaveBlank) {
                break;
            }
            if (!(leadManager.findIndex(id) > -1)){
                isInvalid = true;
                System.out.println("given lead not exist");
            }
        } while (isInvalid);

        return id;
    }

    public String enterInteractionId(String message, boolean leaveBlank){
        InteractionManager interactionManager = InteractionManager.getInstance();
        String id;
        do {
            isInvalid = false;
            id = getInput(message,leaveBlank);
            if(input.equals("") && leaveBlank) {
                break;
            }
            if (!(interactionManager.findIndex(id) > -1)){
                isInvalid = true;
            }
        } while (isInvalid);

        return id;
    }

    public String enterPhone(){
        return "";
    }

    public String enterEmail(){
        return "";
    }

    public String enterGender(){
        return "";
    }
}

