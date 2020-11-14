package baseball;

import java.util.Objects;

public class Validator {
    public static boolean isNumber(String input) {
        try{
            Integer.parseInt(input);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public static boolean isLength3(String input) {
        return Objects.nonNull(input) && input.length() == 3 ? true : false;
    }
}
