package game.ui;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UtilUserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput(UserInterface uiType, String message){
        String userInput = null;

        do{
            try{
                displayMessage(message);
                userInput = requestUserInput(uiType);
                break;
            }catch (Exception e){
                scanner = new Scanner(System.in);
            }
        }while (true);

        return userInput;
    }

    public static void displayMessage(String message){
        System.out.println(message);
    }

    static String requestUserInput(UserInterface uiType) throws Exception{
        String userInput = scanner.nextLine();
        verifyValidInput(uiType, userInput);

        return userInput;
    }

    public static void verifyCommonCondition(String userInput) throws Exception{
        if(isEmpty(userInput)) throw new Exception("아무것도 입력하지 않았습니다");
        if(isContainNonDigit(userInput)) throw new Exception("숫자가 아닌 문자가 포함되었습니다");
    }

    public static void verifyValidInput(UserInterface uiType, String userInput) throws Exception{
        verifyCommonCondition(userInput);

        if(uiType == UserInterface.PITCH){
            if(isNotLengthThree(userInput)) throw new Exception("3자리 숫자가 아닙니다");
            if(isContainDuplicatedDigit(userInput)) throw new Exception("숫자가 중복되었습니다");
        }

        if(uiType == UserInterface.ASK_FINISH){
            if(isContainNonOptionalDigit(userInput)) throw new Exception("1 또는 2가 아닙니다");
        }
    }

    public static boolean isEmpty(String userInput){
        if(userInput.equals("") || userInput == null) return true;
        return false;
    }

    public static boolean isContainNonDigit(String userInput){
        for (int i = 0; i < userInput.length(); i++) {
            char ch = userInput.charAt(i);
            if (ch < 49 || ch > 57) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotLengthThree(String userInput){
        if(userInput.length() != 3) return true;
        return false;
    }

    public static boolean isContainDuplicatedDigit(String userInput){
        Set<Character> digitSet = new HashSet<>();
        for (char i : userInput.toCharArray()) {
            if (digitSet.contains(i)) {
                return true;
            }
            digitSet.add(i);
        }
        return false;
    }

    public static boolean isContainNonOptionalDigit(String userInput){
        if(!userInput.equals("1") &&  !userInput.equals("2")) return true;
        return false;
    }

}
