package baseball.opponent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 야구 게임의 상대 역할을하는 객체
 * 정답을 알고 있으며 사용자가 입력한 답과 비교하여 결과를 알려줌
 *
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
     * 사용자가 입력한 답과 정답을 비교
     *
     * @param inputAnswer 사용자가 입력한 답
     * @return 사용자의 답과 정답을 비교한 결과
     */
    public Map<ResultType, Integer> compare(int inputAnswer) {
        validateInputAnswer(inputAnswer);

        int[] tempAnswers = Arrays.copyOf(answers, ANSWER_LENGTH);
        int[] inputAnswers = splitAnswer(inputAnswer);

        int strikeCount = calcCountStrike(tempAnswers, inputAnswers);
        int ballCount = 0;
        for (int nanoAnswer : inputAnswers)
            ballCount += countBall(tempAnswers, nanoAnswer);

        return createGameResult(strikeCount, ballCount);
    }

    /**
     * 정답을 반환
     * 정답을 외부에 노출하고 싶지 않았지만 정답에 대한 테스트 코드를 작성하기 위해 정의
     *
     * @return 정답
     */
    public int[] getAnswers() {
        return answers;
    }

    /**
     * 스트라이크의 개수를 계산
     *
     * @param answers      정답 배열
     * @param inputAnswers 사용자의 답 배열
     * @return 스트라이크 개수
     */
    private int calcCountStrike(int[] answers, int[] inputAnswers) {
        int strikeCount = 0;
        for (int i = 0; i < answers.length; i++) {
            int count = calcCountAnswer(answers[i], inputAnswers[i]);
            changeArrayToZero(answers, i, isEqualsAnswer(count));
            strikeCount += count;
        }
        return strikeCount;
    }

    /**
     * 볼의 개수를 계산
     *
     * @param answers     정답 배열
     * @param inputAnswer 사용자의 답
     * @return 볼 개수
     */
    private int countBall(int[] answers, int inputAnswer) {
        int ballCount = 0;
        for (int i = 0; i < answers.length; i++) {
            int count = calcCountAnswer(inputAnswer, answers[i]);
            changeArrayToZero(answers, i, isEqualsAnswer(count));
            ballCount += count;
        }
        return ballCount;
    }

    /**
     * 정답과 사용자의 답이 일치하면 1을 반환
     *
     * @param answer      각각의 정답
     * @param inputAnswer 각각의 사용자의 답
     * @return 답이 같으면 1, 다르면 0
     */
    private int calcCountAnswer(int answer, int inputAnswer) {
        if (answer == inputAnswer)
            return 1;

        return 0;
    }

    /**
     * 정답과 사용자의 답이 같으면 중복 검사하게 하지 않기 위해 배열 방의 값을 0으로 변경
     *
     * @param answers        정답 배열
     * @param index          배열 인덱스
     * @param isEqualsAnswer 정답과 사용자의 답이 같다면 true, 다르면 false
     */
    private void changeArrayToZero(int[] answers, int index, boolean isEqualsAnswer) {
        if (isEqualsAnswer) {
            answers[index] = 0;
        }
    }

    /**
     * 각각의 스트라이크 또는 볼의 개수가 1개이면 true 반환
     *
     * @param count 정답 개수 (0 or 1)
     * @return 정답이면 true, 오답이면 false
     */
    private boolean isEqualsAnswer(int count) {
        return count > 0;
    }

    /**
     * 스트라이크와 볼의 개수를 기준으로 정답 비교 결과를 생성
     *
     * @param strikeCount 스트라이크 개수
     * @param ballCount 볼 개수
     * @return 비교 결과
     */
    private Map<ResultType, Integer> createGameResult(int strikeCount, int ballCount) {
        Map<ResultType, Integer> compareResult = new LinkedHashMap<>();

        if (strikeCount != 0)
            compareResult.put(ResultType.STRIKE, strikeCount);

        if (ballCount != 0)
            compareResult.put(ResultType.BALL, ballCount);

        if (strikeCount == 0 && ballCount == 0)
            compareResult.put(ResultType.NOTHING, null);

        return compareResult;
    }

    /**
     * 배열의 저장된 값과 중복되지 않은 랜덤 값을 생성하여 반환
     *
     * @param answers 중복 검사를 위한 정답 배열
     * @return 중복되지 않는 1~9 사이의 랜덤 값
     */
    private int getNonDuplicatedRandomValue(int[] answers) {
        int random = (int) (Math.random() * 8) + 1;

        int[] tempAnswers = Arrays.copyOf(answers, ANSWER_LENGTH);
        Arrays.sort(tempAnswers);

        if (Arrays.binarySearch(tempAnswers, random) >= 0)
            return getNonDuplicatedRandomValue(answers);

        return random;
    }

    /**
     * 사용자가 입력한 답에 대한 유효성 검사
     *
     * @param inputAnswer 사용자가 입력한 답
     */
    private void validateInputAnswer(int inputAnswer) {
        if (inputAnswer <= 99 || 1000 <= inputAnswer)
            throw new IllegalArgumentException("세 자릿수를 입력해 주세요.");

        requireNonZero(inputAnswer);
        requiredNonDuplicate(inputAnswer);
    }

    /**
     * 사용자가 입력한 답에 0이 포함되는지 검사
     *
     * @param inputAnswer 사용자가 입력한 답
     */
    private void requireNonZero(int inputAnswer) {
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            int temp = inputAnswer % 10;
            validatePositive(temp);
            inputAnswer /= 10;
        }
    }

    /**
     * 입력받은 값이 0이면 예외 발생
     *
     * @param eachAnswer 입력받은 각각의 값
     */
    private void validatePositive(int eachAnswer) {
        if (eachAnswer == 0)
            throw new IllegalArgumentException("정답에 0이 포함될 수 없습니다.");
    }

    /**
     * 사용자가 입력한 답에 중복된 값이 있는지 검사
     *
     * @param inputAnswer 사용자가 입력한 답
     */
    private void requiredNonDuplicate(int inputAnswer) {
        int[] inputAnswers = splitAnswer(inputAnswer);

        HashSet<Integer> checkDuplicateSet = new HashSet<>();
        for (int answer : inputAnswers)
            checkDuplicateSet.add(answer);

        if (checkDuplicateSet.size() < 3)
            throw new IllegalArgumentException("중복된 값을 입력할 수 없습니다.");
    }

    /**
     * 사용자가 입력한 세 자릿수를 하나씩 잘라서 배열에 입력
     *
     * @param inputAnswer 사용자가 입력한 답
     * @return 각각의 답이 들어간 배열
     */
    private int[] splitAnswer(int inputAnswer) {
        int[] result = new int[ANSWER_LENGTH];
        for (int i = (ANSWER_LENGTH - 1); i >= 0; i--) {
            result[i] = inputAnswer % 10;
            inputAnswer /= 10;
        }
        return result;
    }

    /**
     * 비교 결과 타입
     */
    public enum ResultType {
        STRIKE("스트라이크"),
        BALL("볼"),
        NOTHING("낫싱");

        public final String desc;

        ResultType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }
}
