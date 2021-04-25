package util;

public class UserNumberUtil {

    public static boolean checkNumberDigit(int inputNumber){
        if(inputNumber < 100 || inputNumber > 999){
            System.out.println("숫자는 3자릿수여야 합니다.");
            return false;
        }
        return true;
    }

}
