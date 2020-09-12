import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandleInput {
    private Scanner console = new Scanner(System.in);
    boolean isInvalid;
    String input;

    public HandleInput(){}

    public String getInput(String message, boolean leaveBlank){
        boolean isInvalid;
        do {
            isInvalid = false;
            System.out.println("Enter " + message);
            input = console.nextLine();
            if(input.equals("") && !leaveBlank){
                isInvalid = true;
                System.out.println("invalid input");
            }
        } while (isInvalid);
        return input.trim();
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


    public String enterPhone(String message, boolean leaveBlank){
        String phone;
        do {
            isInvalid = false;
            phone = getInput(message,leaveBlank);
            if(input.equals("") && leaveBlank) {
                break;
            }
            if (!(phone.length() == 10 && phone.charAt(0) == '0')){
                isInvalid = true;
            }

        } while (isInvalid);

        return phone;
    }

    public String enterEmail(String message, boolean leaveBlank){
        String email;
        String regex = "^\\w+[a-zA-Z0-9]*@\\w+[a-z].\\w+[a-z]$";
        do {
            isInvalid = false;
            email = getInput(message,leaveBlank);
            if(input.equals("") && leaveBlank) {
                break;
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.find()){
                isInvalid = true;
            }

        } while (isInvalid);

        return email;
    }

    public boolean enterGender(String message, boolean leaveBlank){
        String genderString;
        boolean gender = false;
        do {
            isInvalid = false;
            genderString = getInput(message,leaveBlank);
            if(input.equals("") && leaveBlank) {
                break;
            }
            if (genderString.equalsIgnoreCase("M")){
                gender = true;
            } else if (genderString.equalsIgnoreCase("F")){
                gender = false;
            } else
                isInvalid = true;
        } while (isInvalid);

        return gender;
    }
}

