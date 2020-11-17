package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseballJudgeImpl implements BaseballJudge {

    private final int digits;

    public BaseballJudgeImpl(int digits) {
        this.digits = digits;
    }

    @Override
    public int getGameDigitCount() {
        return this.digits;
    }

    @Override
    public int calculateStrikeCount(List<String> input, List<String> answer) {
        int strikeCount = 0;
        for (int index = 0; index < answer.size(); index++) {
            String inputChar = input.get(index);
            String answerChar = answer.get(index);
            strikeCount += (inputChar.equals(answerChar)) ? 1 : 0;
        }
        return strikeCount;
    }

    @Override
    public int calculateBallCount(List<String> input, List<String> answer) {
        int ballCount = 0;
        for (int index = 0; index < answer.size(); index++) {
            String inputChar = input.get(index);
            ballCount += countEqualElementInList(inputChar, index, answer);
        }
        return ballCount;
    }

    @Override
    public String createJudgementMessage(int strikeCount, int ballCount, int digits) {
        if (strikeCount == digits) {
            return String.format("%s개의 숫자를 모두 맞히셨습니다! 게임 종료", this.digits);
        }

        List<String> judgementList = new ArrayList<>();
        createCountMessage(strikeCount, "스트라이크").ifPresent(judgementList::add);
        createCountMessage(ballCount, "볼").ifPresent(judgementList::add);
        return String.join(" ", judgementList);
    }

    private static Optional<String> createCountMessage(int count, String countName) {
        if (count == 0) {
            return Optional.empty();
        }

        return Optional.of(String.format("%d%s", count, countName));
    }

    private static <T> int countEqualElementInList(T element, int exclusiveIndex, List<T> list) {
        int count = 0;
        for (int index = 0; index < list.size(); index++) {
            T listElement = list.get(index);
            count += (index != exclusiveIndex && listElement.equals(element)) ? 1 : 0;
        }
        return count;
    }
}
