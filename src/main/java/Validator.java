import java.util.List;

public class Validator {
    public static boolean validate(String inputNumber) {
        for(int i = 0; i < Constants.DIGITOFNUMBER; i++) {
            if(Character.getNumericValue(inputNumber.charAt(i)) < 0 || Character.getNumericValue(inputNumber.charAt(i)) > 9) {
                return false;
            }
        }
        return true;
    }
}
