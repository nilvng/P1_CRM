import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    private Validator(){}
    public static boolean validateEmail(){
        return false;
    }
    public static boolean validatePhoneNumber(){
        return true;
    }
    public static Date validateDate(String date) throws InvalidInputException {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
//            return true;
        } catch (ParseException e) {
            throw new InvalidInputException("invalid input of date field. Please enter following this format: yyy-MM-dd");
//            return false;
        }
    }

    public static Boolean validateGender(String gender) throws InvalidInputException {
        if (gender.equalsIgnoreCase("Female")){
            return true;
        }
        else if (gender.equalsIgnoreCase("Male")){
            return false;
        }
        else {
            throw new InvalidInputException("invalid input of gender field. It should be either Male or Female");
        }
    }

    public static String validateLeadId(String id) throws InvalidInputException {
        LeadManager leadManager = LeadManager.getInstance();
        if (leadManager.findIndex(id) > -1){
            return id;
        }
        else throw new InvalidInputException("request a non-exist lead");
    }
}
