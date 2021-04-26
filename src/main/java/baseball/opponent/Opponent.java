package baseball.opponent;

import java.util.Arrays;

/**
 * 야구 게임의 상대 역할을하는 객체
 * 정답을 알고 있으며 사용자가 입력한 답과 비교하여 결과를 알려줌
 * @author 김민
 */
public class Opponent {

    private static final int ANSWER_LENGTH = 3;

    private final int[] answers = new int[ANSWER_LENGTH];

    /**
     * 임의의 세 자릿수 정답을 생성
     */
    public void createAnswer() {
        for (int i = 0; i < answers.length; i++)
            answers[i] = getNonDuplicatedRandomValue(answers);
    }

    /**
     * 정답을 반환
     * 정답을 외부에 노출하고 싶지 않았지만 정답에 대한 테스트 코드를 작성하기 위해 정의
     * @return 정답
     */
    public int[] getAnswers() {
        return answers;
    }

    /**
     * 배열의 저장된 값과 중복되지 않은 랜덤 값을 생성하여 반환
     * @param answers 중복 검사를 위한 정답 배열
     * @return 중복되지 않는 1~9 사이의 랜덤 값
     */
    private int getNonDuplicatedRandomValue(int[] answers) {
        int random = (int) (Math.random() * 8) + 1;

        int[] tempAnswers = Arrays.copyOf(answers, ANSWER_LENGTH);
        Arrays.sort(tempAnswers);

        if(Arrays.binarySearch(tempAnswers, random) >= 0)
            return getNonDuplicatedRandomValue(answers);

        return random;
    }
}
