package game.ui;

import java.util.Scanner;

public class UtilUserInterface {

    private static Scanner scanner = new Scanner(System.in);

    public static int viewUI(String message){
        int inputDigit = -1;

        do{
            try{
                displayMessage(message);
                inputDigit = requestUserInput();
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

    static int requestUserInput() throws Exception{
        String inputString = scanner.nextLine();
        verifyValidInput(inputString);

        return Integer.parseInt(inputString);
    }

    public static void verifyValidInput(String inputString) throws Exception{
        if(isEmpty(inputString)) throw new Exception("아무것도 입력하지 않았습니다");
        if(isContainNonDigit(inputString)) throw new Exception("숫자가 아닌 문자가 포함되었습니다");
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
}
