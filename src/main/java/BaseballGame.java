import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame {

    private static String answer;
    private static int restart = 1;

    static void generateRandomNumber() {
        int randomNumber = (int)(Math.random()*1000);
        String stringNumber = String.valueOf(randomNumber);
        answer = stringNumber;
    }

    static void start() {
        Scanner scan = new Scanner(System.in);
        int input;
        String[] splittedAnswer = answer.split("");
        String[] splittedInput;

        while (restart == 1) {
            System.out.print("숫자를 입력해주세요 : ");

            try {
                input = scan.nextInt();
                splittedInput = String.valueOf(input).split("");

                // compare answer with input
            } catch (Exception e) {
                System.out.println("예기치 않은 오류로 종료합니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        generateRandomNumber();
        start();
    }
}
