package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {

    /***
     * 베이스볼 게임의 정답을 랜덤 생성한다.
     * 이 때, 정답은 111~ 999 사이의 중복되는 수가 없는 3자리 수 이다.
     */
    public String makeAnswerNumber() {
        int firstDigit = makeRandomIntRangeOneToNine();
        int secondDigit = makeRandomIntRangeOneToNine();
        int thirdDigit = makeRandomIntRangeOneToNine();

        if (isValidNumberDigit(firstDigit, secondDigit, thirdDigit)) {
            return "" + firstDigit + secondDigit + thirdDigit;
        }

        return makeAnswerNumber();
    }

    private int makeRandomIntRangeOneToNine() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

    private boolean isValidNumberDigit(int firstDigit, int secondDigit, int thirdDigit) {
        return (firstDigit != secondDigit && firstDigit != thirdDigit && secondDigit != thirdDigit);
    }

    /**
     * 입력으로 받은 정답 예측수가 베이스볼 게임에 유효한 숫자인지 여부를 판단한다.
     */
    public boolean isValidInput(String input) {
        return isInValidRange(Integer.parseInt(input))
                && isInValidRangeDigit(input)
                && isValidNumberDigit(input);
    }

    private boolean isInValidRange(int input) {
        return input >= 111 && input <= 999;
    }

    private boolean isValidNumberDigit(String predictionNumber) {
        return predictionNumber.charAt(0) != predictionNumber.charAt(1)
                && predictionNumber.charAt(0) != predictionNumber.charAt(2)
                && predictionNumber.charAt(1) != predictionNumber.charAt(2);
    }

    private boolean isInValidRangeDigit(String predictionNumber) {
        List<Boolean> checkResult = new ArrayList<>();
        for (int i = 0; i < predictionNumber.length(); ++i) {
            checkResult.add(isInOneToNine(predictionNumber.charAt(i)));
        }
        return !checkResult.contains(false);
    }

    private boolean isInOneToNine(char ascii) {
        int number = ascii - 48;
        return number >= 1 && number <= 9;
    }

    /**
     * Baseball 정답과 예측수를 비교하여 Strike의 개수를 센다.
     */
    public int countStrikes(String answerNumber, String predictionNumber) {
        int count = 0;

        for (int i = 0; i < answerNumber.length(); ++i) {
            count += countIfStrike(answerNumber.charAt(i), predictionNumber.charAt(i));
        }

        return count;
    }

    private int countIfStrike(char answerChar, char predictionChar) {
        if (answerChar == predictionChar) {
            return 1;
        }
        return 0;
    }

    /**
     * Baseball 정답과 예측수를 비교하여 Ball의 개수를 센다.
     */
    public int countBalls(String answerNumber, String predictionNumber) {
        int count = 0;

        for (int i = 0; i < answerNumber.length(); ++i) {
            int sameIndex = predictionNumber.indexOf(answerNumber.charAt(i));

            count += countIfBall(i, sameIndex);
        }

        return count;
    }

    private int countIfBall(int answerIndex, int sameIndex) {
        if (answerIndex != sameIndex && sameIndex != -1) {
            return 1;
        }
        return 0;
    }

    /**
     * Baseball 정답수와 예측수를 비교 판단한 결과로 출력할 문장을 만들어낸다.
     */
    public String makeResultStringOf(Judgement judgement) {
        if (judgement.hasStrikeCount() || judgement.hasBallCount()) {
            return hasSomethingCase(judgement);
        }

        return "낫싱";
    }

    private String hasSomethingCase(Judgement judgement) {
        StringBuffer sb = new StringBuffer("");

        sb.append(makeStrikeCountOf(judgement));
        sb.append(addIfNeedSpace(judgement));
        sb.append(makeBallCountOf(judgement));
        sb.append(addIfAllStrike(judgement));

        return sb.toString();
    }

    private String makeStrikeCountOf(Judgement judgement) {
        if (judgement.strikeCount > 0) {
            return judgement.strikeCount + " 스트라이크";
        }
        return "";
    }

    private String addIfNeedSpace(Judgement judgement) {
        if (judgement.hasBothCount()) {
            return " ";
        }
        return "";
    }

    private String makeBallCountOf(Judgement judgement) {
        if (judgement.ballCount > 0) {
            return judgement.ballCount + " 볼";
        }
        return "";
    }

    private String addIfAllStrike(Judgement judgement) {
        if (judgement.strikeAll()) {
            return "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                    "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }
        return "";
    }
}
