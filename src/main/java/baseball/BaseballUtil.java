package baseball;

import java.util.Scanner;

public class BaseballUtil {

    public String inputNumber(int byNumber){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while(!isDigit(input, byNumber)){
            input = sc.nextLine();
        }
        return input;
    }

    public boolean isDigit(String input, int isByNumber) {
        char temp;
        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (!('1' <= temp && temp <= (char)(isByNumber+'0'))) {
                System.out.println(Message.INVALID.getMessage());
                return false;
            }
        }
        return true;
    }

}
