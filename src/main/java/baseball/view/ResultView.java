package baseball.view;

import baseball.model.CompareResult;

import static baseball.util.ValidateNumberUtil.NUMBER_LENGTH;

public class ResultView {
    private ResultView() {
    }

    public static void invalidNumberMessage() {
        System.out.println("중복 없는 세 자릿수를 입력해 주세요");
    }

    public static void resultPrint(CompareResult compareResult) {
        if (compareResult.strikeCount() == 0 && compareResult.ballCount() == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(compareResult.strikeCount() + " 스트라이크 " + compareResult.ballCount() + " 볼");
    }

    public static void allStrikePrint() {
        System.out.println(NUMBER_LENGTH + " 스트라이크 ");
        System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
