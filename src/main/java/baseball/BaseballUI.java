package baseball;

import java.util.Scanner;

public class BaseballUI {

    private Number generateNumbers = new Number();
    private BaseballService baseballService = new BaseballService();
    private Referee referee;
    private Scanner sc = new Scanner(System.in);

    public boolean startGame() {

        referee = new Referee();
        System.out.print("숫자를 입력해주세요.");
        int inputValue = sc.nextInt();

        if (!baseballService.validateInputValue(inputValue)) {
            return true;
        }

        baseballService.compareNumber(referee, generateNumbers, inputValue);
        System.out.println(printResult(referee));

        if (!printResult(referee).equals("3스트라이크 ")) {
            return true;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return checkInputContinueButton();

    }

    public boolean checkInputContinueButton() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int continueButton = sc.nextInt();

        if (continueButton == 1) {
            generateNumbers = new Number();
            return true;
        }

        if (continueButton == 2) {
            sc.close();
            return false;
        }

        System.out.println("잘못 된 값이 입력되었습니다.");
        return checkInputContinueButton();

    }

    public String printResult(Referee referee) {

        String result = "";

        if (referee.getStrike() != 0) {
            result = result + referee.getStrike() + "스트라이크 ";
        }

        if (referee.getBall() != 0) {
            result = result + referee.getBall() + "볼 ";
        }

        if (result.equals("")) {
            result = "낫싱";
        }

        return result;

    }

}
