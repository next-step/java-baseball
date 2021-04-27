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

        if (!baseballService.validateInputValue(inputValue)) { // 플레이어 입력값 검증
            return true;
        }

        baseballService.compareNumber(referee, generateNumbers, inputValue); // 플레이어 입력값과 컴퓨터 선택값 비교
        String result = baseballService.setResult(referee); // 결과 출력용 메세지 설정
        System.out.println(result);

        if (!result.equals("3스트라이크 ")) {
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

}
