import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    private Validator(){}
    public static boolean validateEmail(){
        return false;
    }

    public static Date enterDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
//            return true;
        } catch (ParseException e) {
            System.out.println("cannot parse");
            return null;
//            return false;
        }
    }

    public static Boolean enterBoolean(String bool){
        // default value of lead gender is female or false
        return Boolean.parseBoolean(bool);
    }

    public static Boolean DoesLeadExist(String id){
        LeadManager leadManager = LeadManager.getInstance();
        return (leadManager.findIndex(id) > -1);
    }
}
