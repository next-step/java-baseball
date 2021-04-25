package input;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputApi {

    /*
        입력 메서드
     */
    public static String input(String message, String condition){
        String inStr;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print(message);
            inStr = scanner.nextLine();
        }while(!checkValidIn(inStr, condition));
        return inStr;
    }

    /*
        입력된 String의 유효성을 체크한다
        1. 게임 시작 유효성 체크
            1) 숫자가 입력 되었는지
            2) 1또는 2가 입력되었는지
        2. 예상 숫자 입력 유효성 체크
            1) 숫자가 입력 되었는지
            2) 3자리 숫자인지(0을 제외한 숫자)
     */
    private static boolean checkValidIn(String input, String condition){
        boolean ret = condition.equals("number") ? gameInputValid(input) : input.matches("[1-2]{1}");

        return ret;
    }

    /*
        게임 중 사용자 입력 값 유효성 체크
    */
    private static boolean gameInputValid(String input){
        if(!input.matches("[1-9]{3}"))
            return false;
        Set<Integer> chkNum = new HashSet<Integer>();
        for(char c : input.toCharArray()){
            int a = c - '0';
            chkNum.add(a);
        }

        return chkNum.size() == 3 ? true : false;
    }
}
