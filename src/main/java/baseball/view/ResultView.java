package baseball.view;

import baseball.model.CompareResult;

import static baseball.util.ValidateNumberUtil.NUMBER_LENGTH;

public class ResultView {

    private static final int NOTHING = 0;

    private ResultView() {
    }

    public static void invalidNumberMessage() {
        System.out.println("중복 없는 세 자릿수를 입력해 주세요");
    }

    public static void resultPrint(CompareResult compareResult) {

        StringBuilder resultMessage = new StringBuilder();

        if (compareResult.strikeCount() == NOTHING && compareResult.ballCount() == NOTHING) {
            System.out.println("낫싱");
            return;
        }

        resultMessage.append(strikeMessageAppend(compareResult.strikeCount()));
        resultMessage.append(ballMessageAppend(compareResult.ballCount()));

        System.out.println(resultMessage);
    }

    public static void allStrikePrint() {
        System.out.println(NUMBER_LENGTH + " 스트라이크");
        System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static String strikeMessageAppend(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + " 스트라이크 ";
    }

    private static String ballMessageAppend(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + " 볼";
    }
}
