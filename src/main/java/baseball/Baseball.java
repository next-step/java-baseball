package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {

    /***
     * 베이스볼 게임의 정답을 랜덤 생성한다.
     * 이 때, 정답은 111~ 999 사이의 중복되는 수가 없는 3자리 수 이다.
     */
    public String makeBaseballNumberString() {
        int firstDigit = makeRandomIntRangeOneToNine();
        int secondDigit = makeRandomIntRangeOneToNine();
        int thirdDigit = makeRandomIntRangeOneToNine();

        if (isValidBaseballNumberDigit(firstDigit, secondDigit, thirdDigit)) {
            return "" + firstDigit + secondDigit + thirdDigit;
        }

        return makeBaseballNumberString();
    }

    private int makeRandomIntRangeOneToNine() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

    private boolean isValidBaseballNumberDigit(int firstDigit, int secondDigit, int thirdDigit) {
        return (firstDigit != secondDigit && firstDigit != thirdDigit && secondDigit != thirdDigit);
    }

    /**
     * 입력으로 받은 정답 예측수가 베이스볼 게임에 유효한 숫자인지 여부를 판단한다.
     */
    public boolean isValidBaseballInputNumber(int input) {
        String inputString = Integer.toString(input);
        return isInValidRange(input)
                && isInValidRangeDigit(inputString)
                && isValidNumberDigit(inputString);
    }

    private boolean isInValidRange(int input) {
        return input >= 111 && input <= 999;
    }

    private boolean isValidNumberDigit(String predictionNumberString) {
        return predictionNumberString.charAt(0) != predictionNumberString.charAt(1)
                && predictionNumberString.charAt(0) != predictionNumberString.charAt(2)
                && predictionNumberString.charAt(1) != predictionNumberString.charAt(2);
    }

    private boolean isInValidRangeDigit(String predictionNumberString) {
        List<Boolean> checkResult = new ArrayList<>();
        for (int i = 0; i < predictionNumberString.length(); ++i) {
            checkResult.add(isInOneToNine(predictionNumberString.charAt(i)));
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
    public int countStrikes(String baseballNumber, String predictionNumber) {
        int count = 0;

        for (int i = 0; i < baseballNumber.length(); ++i) {
            count += countIfStrike(baseballNumber.charAt(i), predictionNumber.charAt(i));
        }

        return count;
    }

    private int countIfStrike(char baseballChar, char predictionChar) {
        return baseballChar == predictionChar ? 1 : 0;
    }

    /**
     * Baseball 정답과 예측수를 비교하여 Ball의 개수를 센다.
     */
    public int countBalls(String baseballNumber, String predictionNumber) {
        int count = 0;

        for (int baseballNumberIndex = 0; baseballNumberIndex < baseballNumber.length(); ++baseballNumberIndex) {
            int sameIndex = predictionNumber.indexOf(baseballNumber.charAt(baseballNumberIndex));

            count += countIfBall(baseballNumberIndex, sameIndex);
        }

        return count;
    }

    private int countIfBall(int i, int sameIndex) {
        return i != sameIndex && sameIndex != -1 ? 1 : 0;
    }

    /**
     * Baseball 정답수와 예측수를 비교 판단한 결과로 출력할 문장을 만들어낸다.
     */
    public String makeComparisonResultString(BaseballComparisonResult comparisonResult) {
        if (comparisonResult.hasStrikeCount() || comparisonResult.hasBallCount()) {
            return hasSomethingCase(comparisonResult);
        }

        return "낫싱";
    }

    private String hasSomethingCase(BaseballComparisonResult comparisonResult) {
        StringBuffer sb = new StringBuffer("");

        sb.append(makeStrikeCountString(comparisonResult.strikeCount));
        sb.append(addIfNeedSpace(comparisonResult.hasBothCount()));
        sb.append(makeBallCountString(comparisonResult.ballCount));
        sb.append(addIfAllStrike(comparisonResult.strikeAll()));

        return sb.toString();
    }

    private String makeStrikeCountString(int strikeCount) {
        if (strikeCount > 0) {
            return strikeCount + " 스트라이크";
        }
        return "";
    }

    private String addIfNeedSpace(boolean needSpace) {
        return needSpace ? " " : "";
    }

    private String makeBallCountString(int ballCount) {
        if (ballCount > 0) {
            return ballCount + " 볼";
        }
        return "";
    }

    private String addIfAllStrike(boolean allStrike) {
        if (allStrike) {
            return "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                    "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }
        return "";
    }
}
