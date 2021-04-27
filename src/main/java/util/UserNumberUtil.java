package util;

import java.util.Scanner;

public class UserNumberUtil {

    public static boolean checkNumberDigit(int inputNumber){

        if(inputNumber < 100 || inputNumber > 999){
            //System.out.println("숫자는 3자리 양수여야 합니다.");
            return false;
        }

        return checkNumberNonZero(inputNumber);
    }

    public static boolean checkNumberNonZero(int inputNumber){
        int checkNumber = inputNumber / 10;
        if(inputNumber % 10 == 0 || checkNumber % 10 == 0){
            //System.out.println("0을 포함해서는 안됩니다.");
            return false;
        }
        return true;
    }

    public static int inputUserNumber(){

        int inputNumber = 0;
        try{
            Scanner sc = new Scanner(System.in);
            inputNumber = Integer.parseInt(sc.nextLine());
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return -1;
        }
        return inputNumber;

    }

}
