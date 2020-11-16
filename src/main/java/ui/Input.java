package ui;

import java.util.Scanner;

import static common.Constant.TEXT_INPUT;

public class Input {

    // 사용자 입력 메서드 : UI 담당 메서드
    public static int[] userInput() {
        Scanner scanner = new Scanner(System.in);
        String[] userInput;

        do {
            System.out.println(TEXT_INPUT);
            userInput = scanner.nextLine().split("");

        } while (!validatorCheckNumber(userInput));
        int[] inputNumbers = new int[3];
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = Integer.parseInt(userInput[i]);
        }
        return inputNumbers;

    }

    // 사용자 입력 에러 체크
    public static boolean validatorCheckNumber(String[] userInput) {

        boolean checkNumber = true;
        // 유저로부터 입력받은수가 3자리 이상일 경우
        if (userInput.length > 3) {
            System.err.println("3자리 이하 숫자로 입력해 주세요");
            checkNumber = false;
        }
        if (userInput.length == 1 || userInput.length < 3) {
            System.err.println("3개의 숫자를 입력해주세요.");
            checkNumber = false;
        }
        return checkNumber;
    }


}
