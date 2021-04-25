package input;

import java.util.Scanner;

public class InputApi {
    enum Message {
        NUMBER("숫자를 입력해 주세요");


    }
    public static String input(String ){
        String inStr;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("숫자를 입력해주세요 : ");
            inStr = scanner.nextLine();
        }while(!checkValidIn(inStr, "number"));
        return inStr;
    }
    /*
        숫자 입력 메서드
     */
    public static String inputNumber(){
        String inStr;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("숫자를 입력해주세요 : ");
            inStr = scanner.nextLine();
        }while(!checkValidIn(inStr, "number"));
        return inStr;
    }

    /*
        게임 시작 입력 메서드
     */
    public static String inputStart(){
        String inStr;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inStr = scanner.nextLine();
        }while(!checkValidIn(inStr, "start"));
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
        boolean ret = condition.equals("number") ? input.matches("[1-9]{3}") : input.matches("[1-2]{1}");

        return ret;
    }

}
