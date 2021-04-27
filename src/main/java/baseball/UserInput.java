package baseball;

import common.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public static String inputThreeNumbers() {
        Scanner sc = new Scanner(System.in);
        int numbers;
        System.out.print("숫자를 입력해주세요 : ");
        try {
            numbers = sc.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("숫자만 입력해주세요!");
            return Constants.INPUT_NUMBER_ERROR;
        }
        return String.valueOf(numbers);
    }

    public static String inputContinueGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
        return sc.next();
    }

    public static void main(String[] args) {
        System.out.println(UserInput.inputThreeNumbers());
        System.out.println(UserInput.inputContinueGame());
    }
}
