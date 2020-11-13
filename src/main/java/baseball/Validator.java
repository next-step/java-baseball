package baseball;

public class Validator {
    public static boolean isNumber(String input) {
        try{
            Integer.parseInt(input);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
}
