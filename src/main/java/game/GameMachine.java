package game;

import static game.GameConstant.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class GameMachine {

    private final Set<Integer> randomSet = new LinkedHashSet<>();

    public static GameMachine of() {
        return new GameMachine();
    }

    public int getRandomSetSize() {
        return randomSet.size();
    }

    /**
     * 랜덤 설정값 초기화
     */
    public void init() {
        randomSet.clear();
        while (randomSet.size() < RANDOM_VALUE_MAX_LENGTH) {
            int randomValue = (int) (Math.random() * 9) + 1;
            randomSet.add(randomValue);
        }
    }

    /**
     * 랜덤 설정값 초기화
     * @param inputs 사용자 입력값
     */
    public void init(int[] inputs) {
        randomSet.clear();
        for (int value : inputs) {
            validateRandomValue(value);
            randomSet.add(value);
        }
        if (randomSet.size() < RANDOM_VALUE_MAX_LENGTH) {
			throw new IllegalStateException(ERR_DUPLICATE_VALUE);
        }
    }

    /**
     * 랜덤 값 유효성 검사
     * @param value 숫자값
     */
    private void validateRandomValue(int value) {
        if (value < 1 || value > 9) {
			throw new IllegalArgumentException(ERR_RANDOM_VALUE);
        }
    }

    /**
     * 랜덤 값(=문자열) 유효성 검사
     * @param value 문자값
     */
    private void validateRandomValue(String value) {
        String regExp = "^[1-9]";
        if (!value.matches(regExp)) {
            throw new IllegalArgumentException(ERR_RANDOM_VALUE);
        }
    }

    /**
     * 입력 값 전체 유효성 검사
     * @param inputs 문자열 입력값 전체
     * @return 유효 여부
     */
    public boolean isValid(String[] inputs) {
        Set<Integer> inputSet = new HashSet<>();

        if (inputs.length != RANDOM_VALUE_MAX_LENGTH) {
            throw new IllegalArgumentException(ERR_INPUT_LENGTH);
        }

        for (String value : inputs) {
            validateRandomValue(value);
            inputSet.add(Integer.parseInt(value));
        }

        if (inputSet.size() < RANDOM_VALUE_MAX_LENGTH) {
            throw new IllegalStateException(ERR_DUPLICATE_VALUE);
        }
        return true;
    }

    /**
     * 사용자 입력에 대한 결과 확인
     * @param inputs 사용자가 전달한 String 배열
     * @return 체크 결과에 대한 int 배열
     */
    public int[] check(String[] inputs) {
        int[] result = new int[RANDOM_VALUE_MAX_LENGTH];
        List<Integer> randomList = new ArrayList<>(randomSet);

        for (int i = 0; i < inputs.length; i++) {
            int num = Integer.parseInt(inputs[i]);
            int index = randomSet.contains(num) ?
				getIndexResult(randomList.get(i), num) : GameResultStatus.NOTING.getIndex();
            result[index]++;
        }

        return result;
    }

    /**
     * 랜덤값, 사용자 입력값 비교
     * @param random 랜덤 설정값
     * @param target 사용자 입력값
     * @return GameResultStatus 인덱스
     */
    private int getIndexResult(int random, int target) {
        return (random == target) ? GameResultStatus.STRIKE.getIndex() : GameResultStatus.BALL.getIndex();
    }

    /**
     * 체크 결과 문자열 출력
     * @param result 체크결과로 받은 int 배열
     * @return 결과에 대한 문자열
     */
    public String print(int[] result) {
        if (result[GameResultStatus.NOTING.getIndex()] == 3) {
            return GameResultStatus.NOTING.getName();
        }

        StringBuilder stb = new StringBuilder();
        if (result[GameResultStatus.STRIKE.getIndex()] > 0) {
            stb.append(result[GameResultStatus.STRIKE.getIndex()])
			   .append(GameResultStatus.STRIKE.getName()).append(DELIMITER);
        }
        if (result[GameResultStatus.BALL.getIndex()] > 0) {
            stb.append(result[GameResultStatus.BALL.getIndex()]).append(GameResultStatus.BALL.getName());
        }
        return stb.toString().trim();
    }
}
