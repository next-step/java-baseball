package game.baseball.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static game.baseball.constant.BaseballConfig.*;

public class Answer {
    /**
     * 랜덤하게 생성된 정답
     */
    private final List<Integer> answerNumberList;

    public Answer(List<Integer> randomNumberList) {
        validateListCount(randomNumberList);
        validateContainDuplicate(randomNumberList);
        this.answerNumberList = randomNumberList;
    }

    private void validateListCount(List<Integer> randomNumberList) {
        if (randomNumberList.size() != ANSWER_COUNT) {
            throw new IllegalArgumentException("정답의 갯수가 설정과 일치하지 않습니다.");
        }
    }

    private void validateContainDuplicate(List<Integer> randomNumberList) {
        Set<Integer> set = new HashSet<>(randomNumberList);
        if (set.size() != ANSWER_COUNT) {
            throw new IllegalArgumentException("중복된 숫자가 정답에 포함되어 있습니다.");
        }
    }

    public int getIndexOfNumberInAnswer(int num) {
        return answerNumberList.indexOf(num);
    }
}
