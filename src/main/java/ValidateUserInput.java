import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateUserInput {
    private ValidateUserInput(){}
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
}
