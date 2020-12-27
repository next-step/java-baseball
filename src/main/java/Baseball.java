/**
 * Baseball.java
 * 2020년 12월 26일 생성
 * 아무 제약 없이 사용할 수 있는 소스코드입니다
 */

import java.util.Scanner;

public class Baseball {
    final private static int INPUT_LENGTH = 3;
    final private static Scanner scanner = new Scanner(System.in);

    public static void run(){
        int balls;
        int strikes;
        String opponentInput = generateBaseballNumbers();
        do {
            String userInput = getValidUserInput();
            balls = countBalls(userInput, opponentInput);
            strikes = countStrikes(userInput, opponentInput);
            printBallsAndStrikes(balls, strikes);
        } while(strikes != INPUT_LENGTH);
        System.out.println(INPUT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private static void printBallsAndStrikes(int balls, int strikes) {
        if((balls == 0) && (strikes == 0)){
            System.out.println("낫싱");
            return;
        }
        if(strikes > 0){
            System.out.print(strikes + " 스트라이크 ");
        }
        if(balls > 0){
            System.out.print(balls + " 볼");
        }
        System.out.println();
    }

    private static String getValidUserInput(){
        String userInput;
        do {
            System.out.println(INPUT_LENGTH + "자리 숫자를 입력해주세요 : ");
            userInput = scanner.next();
        } while (!isValidInput(userInput));
        return userInput;
    }

    public static String generateBaseballNumbers() {
        String s = "";
        while(s.length() < INPUT_LENGTH){
            int random0to9 = (int) (Math.random() * 10);
            s += (s.contains(Integer.toString(random0to9))) ? "" : random0to9;      /* 이미 중복된 문자열은 피하도록 한다 */
        }
        return s;
    }

    public static int countBalls(String a, String b){
        int balls = 0;
        for(int i=0; i<INPUT_LENGTH; i++){
            String s = StringController.chopAt(b, i);
            balls += (s.indexOf(a.charAt(i)) >= 0) ? 1 : 0;
        }
        return balls;
    }

    public static int countStrikes(String a, String b) {
        int strikes = 0;
        for(int i=0; i<INPUT_LENGTH; i++){
            strikes += (a.charAt(i) == b.charAt(i)) ? 1 : 0;
        }
        return strikes;
    }

    public static boolean isValidInput(String in) {
        if(!in.matches("^[0-9]+$")) {
            return false;
        }
        if(in.length() != Baseball.INPUT_LENGTH) {
            return false;
        }
        if(StringController.hasDuplicatedChar(in)){
            return false;
        }
        return true;
    }
}
