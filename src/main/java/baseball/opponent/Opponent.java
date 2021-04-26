package baseball.opponent;

import java.util.Arrays;

/**
 * 야구 게임의 상대 역할을하는 객체
 * 정답을 알고 있으며 사용자가 입력한 답과 비교하여 결과를 알려준다.
 * @author min
 */
public class Opponent {

    private static final int ANSWER_LENGTH = 3;

    private final int[] answers = new int[ANSWER_LENGTH];

    /**
     * 정답을 생성한다.
     */
    public void createAnswer() {
        for (int i = 0; i < answers.length; i++)
            answers[i] = getNonDuplicatedRandomValue(answers);
    }


    /**
     * 배열의 저장된 값과 중복되지 않은 랜덤 값을 생성하여 반환한다.
     * @param answers 중복 검사를 위한 정답 배열
     * @return 중복되지 않는 1~9 사이의 랜덤 값
     */
    private int getNonDuplicatedRandomValue(int[] answers) {
        int random = (int) (Math.random() * 8) + 1;

        int[] tempAnswers = Arrays.copyOf(answers, 3);
        Arrays.sort(tempAnswers);

        if(Arrays.binarySearch(tempAnswers, random) >= 0)
            return getNonDuplicatedRandomValue(answers);

        return random;
    }
}
