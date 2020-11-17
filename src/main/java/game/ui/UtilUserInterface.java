package game.ui;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UtilUserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static int viewUI(UserInterface uiType, String message){
        int inputDigit = -1;

        do{
            try{
                displayMessage(message);
                inputDigit = requestUserInput(uiType);
                break;
            }catch (Exception e){
                scanner = new Scanner(System.in);
            }
        }while (true);

        return inputDigit;
    }

    public static void displayMessage(String message){
        System.out.println(message);
    }

    static int requestUserInput(UserInterface uiType) throws Exception{
        String inputString = scanner.nextLine();
        verifyValidInput(uiType, inputString);

        return Integer.parseInt(inputString);
    }

    public static void verifyCommonCondition(String inputString) throws Exception{
        if(isEmpty(inputString)) throw new Exception("아무것도 입력하지 않았습니다");
        if(isContainNonDigit(inputString)) throw new Exception("숫자가 아닌 문자가 포함되었습니다");
    }

    public static void verifyValidInput(UserInterface uiType, String inputString) throws Exception{
        verifyCommonCondition(inputString);

        if(uiType == UserInterface.PITCH){
            if(isNotLengthThree(inputString)) throw new Exception("3자리 숫자가 아닙니다");
            if(isContainDuplicatedDigit(inputString)) throw new Exception("숫자가 중복되었습니다");
        }

        if(uiType == UserInterface.ASK_FINISH){
            if(isContainNonOptionalDigit(inputString)) throw new Exception("1 또는 2가 아닙니다");
        }
    }

    public static boolean isEmpty(String inputString){
        if(inputString.equals("") || inputString == null) return true;
        return false;
    }

    public static boolean isContainNonDigit(String inputString){
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (ch < 48 || ch > 57) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotLengthThree(String inputString){
        if(inputString.length() != 3) return true;
        return false;
    }

    public static boolean isContainDuplicatedDigit(String inputString){
        Set<Character> digitSet = new HashSet<>();
        for (char i : inputString.toCharArray()) {
            if (digitSet.contains(i)) {
                return true;
            }
            digitSet.add(i);
        }
        return false;
    }

    public static boolean isContainNonOptionalDigit(String inputString){
        if(!inputString.equals("1") &&  !inputString.equals("2")) return true;
        return false;
    }

}
