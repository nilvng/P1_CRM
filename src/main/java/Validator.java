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
            return new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Boolean enterBoolean(String bool){
        // default value of lead gender is female or false
        return Boolean.parseBoolean(bool);
    }
}
