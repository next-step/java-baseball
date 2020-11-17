import java.util.List;

public class NumberComparator {
    public static BaseballCompareResult compare(int inputFirst, int inputSecond) {
        if (NumberGenerator.checkRightData(inputFirst) == false) throw new IllegalArgumentException("올바른 데이터가 아닙니다.");
        if (NumberGenerator.checkRightData(inputSecond) == false) throw new IllegalArgumentException("올바른 데이터가 아닙니다.");

        // 볼 카운트 계산
        int ballCount = calculateBallCount(inputFirst, inputSecond);
        // 스트라이크 카운트 계산
        int strikeCount = calculateStrikeCount(inputFirst, inputSecond);

        return new BaseballCompareResult(ballCount, strikeCount);
    }

    public static int calculateBallCount(int inputFirst, int inputSecond) {
        List<Integer> singleDigitsFirst = NumberGenerator.toSingleDigitArray(inputFirst);
        List<Integer> singleDigitsSecond = NumberGenerator.toSingleDigitArray(inputSecond);
        int ballCount = 0;
        for (int i = 0; i < singleDigitsFirst.size(); i++)
            for (int k = 0; k < singleDigitsSecond.size(); k++)
                if(i != k && singleDigitsFirst.get(i).equals(singleDigitsSecond.get(k)))
                    ballCount++;
        return ballCount;
    }

    public static int calculateStrikeCount(int inputFirst, int inputSecond) {
        List<Integer> singleDigitsFirst = NumberGenerator.toSingleDigitArray(inputFirst);
        List<Integer> singleDigitsSecond = NumberGenerator.toSingleDigitArray(inputSecond);
        int strikeCount = 0;
        for (int i = 0; i < singleDigitsFirst.size(); i++)
            for (int k = 0; k < singleDigitsSecond.size(); k++)
                if(i == k && singleDigitsFirst.get(i).equals(singleDigitsSecond.get(k)))
                    strikeCount++;
        return strikeCount;
    }
}
