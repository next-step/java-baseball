package baseball;

import baseball.dto.BaseballGameJudgeDto;

import java.util.Scanner;

public class BaseballGameIO {

    private Scanner scanner = new Scanner(System.in);


    public String scanInputNumber() {
        String inputData;

        do {
            inputData = scanner.nextLine();
        } while (!checkValidateInputNumber(inputData));

        return inputData;
    }

    private boolean checkValidateInputNumber(String input) {
        if (!isRightInputNumberLength(input)) {
            return false;
        }

        if (!isRightInputNumberInteger(input)) {
            return false;
        }

        return true;
    }

    private boolean isRightInputNumberInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.print("숫자만 입력하세요. 다시 입력하세요 : ");
            return false;
        }

        return true;
    }

    private boolean isRightInputNumberLength(String input) {
        if (input.length() != 3) {
            System.out.print("숫자가 3자리가 아닙니다. 다시 입력하세요 : ");
            return false;
        }

        return true;
    }

    public boolean scanReplay() {
        int inputData;
        do {
            try {
                inputData = scanner.nextInt();
            } catch (Exception e) { // 입력이 Int 가 아닌 경우 발생
                inputData = -1; // checkValidateReplay 에서 처리되게 -1 값
            }
            scanner.nextLine(); // buffer clear
        } while (!checkValidateReplay(inputData));
        return inputData == 1;
    }

    private boolean checkValidateReplay(int input) {
        if (input == 1 || input == 2) {
            return true;
        }

        System.out.println("1 또는 2 를 입력하세요.");
        printReplay();
        return false;
    }

    ////////////////////////////////////
    // print
    public void printBye() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printInputComment() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printJudgeResult(BaseballGameJudgeDto judgeDto) {
        int strike = judgeDto.getStrike();
        int boll = judgeDto.getBoll();
        printStrike(strike);
        printBoll(boll);
        if (strike == 0 && boll == 0) {
            System.out.println("낫싱");
        }

        System.out.print("\n");
    }

    private void printStrike(int strike) {
        if (strike > 0) {
            System.out.printf("%d 스트라이크 ", strike);
        }
    }

    private void printBoll(int boll) {
        if (boll > 0) {
            System.out.printf("%d 볼 ", boll);
        }
    }
}
