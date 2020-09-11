import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HandleUserInput {
    private Scanner console = new Scanner(System.in);
    boolean isInValid;
    String input;

    public String getInput(String message){
        System.out.println("Enter "  + message);
        return console.nextLine();
    }

    public String enterString(String message, boolean leaveBlank){
        do {
            isInValid = false;
            input = getInput(message);
//            if (!leaveBlank && ){
//
//            }
        } while (isInValid);
        return input;
    }

    public String enterSpecificString(String message, List<String> specificInput, boolean leaveBlank){
        do {
            isInValid = false;
            input = getInput(message);
            if (!specificInput.contains(input)){
                isInValid = true;
            }
        } while (isInValid);
        return input;
    }

    public Date enterDate(String message, boolean leaveBlank){
        Date dateInput = null;
        do {
            isInValid = false;
            input = getInput(message);
            try {
                dateInput  = new SimpleDateFormat("yyyy-MM-dd").parse(input);
            } catch (ParseException e) {
                isInValid = true;
            }
        } while (isInValid);
        return dateInput;
    }

    public String enterLeadId(String message, boolean leaveBlank){
        LeadManager leadManager = LeadManager.getInstance();
        String id;
        do {
            isInValid = false;
            id = getInput(message);
            if (!(leadManager.findIndex(id) > -1)){
                isInValid = true;
            }
        } while (isInValid);

        return id;
    }

    public String enterInteractionId(String message, boolean leaveBlank){
        InteractionManager interactionManager = InteractionManager.getInstance();
        String id;
        do {
            isInValid = false;
            id = getInput(message);
            if (!(interactionManager.findIndex(id) > -1)){
                isInValid = true;
            }
        } while (isInValid);

        return id;
    }

}

