package game;

import java.util.*;

public class GameMachine {

    public final static int RANDOM_VALUE_MAX_LENGTH = 3;

    private final Set<Integer> randomSet = new LinkedHashSet<>();

    public static GameMachine of() {
        return new GameMachine();
    }

    public int getRandomSetSize() {
        return randomSet.size();
    }

    public void init() {
        randomSet.clear();
        while (randomSet.size() < RANDOM_VALUE_MAX_LENGTH) {
            int randomValue = (int) (Math.random() * 9) + 1;
            randomSet.add(randomValue);
        }
    }

    public void init(int[] inputs) {
        randomSet.clear();
        for (int value : inputs) {
            isRandomValue(value);
            randomSet.add(value);
        }
        if (randomSet.size() < RANDOM_VALUE_MAX_LENGTH)
            throw new IllegalStateException("중복된 값이 존재합니다");
    }

    private void isRandomValue(int value) {
        if (value < 1 || value > 9)
            throw new IllegalArgumentException("랜덤 값은 1 ~ 9까지 수여야 합니다");
    }

    private void isRandomValue(String value) {
        String regExp = "^[1-9]";
        if (!value.matches(regExp))
            throw new IllegalArgumentException("랜덤 값은 1 ~ 9까지 수여야 합니다");
    }

    public boolean isValid(String[] inputs) {
        Set<Integer> inputSet = new HashSet<>();

        if (inputs.length != RANDOM_VALUE_MAX_LENGTH)
            throw new IllegalArgumentException("입력된 값의 길이는 반드시 3이어야 합니다");

        for (String value : inputs) {
            isRandomValue(value);
            inputSet.add(Integer.parseInt(value));
        }

        if (inputSet.size() < RANDOM_VALUE_MAX_LENGTH)
            throw new IllegalStateException("중복된 값이 존재합니다");

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
            int index = randomSet.contains(num) ? getIndexResult(randomList.get(i), num) : ResultStatus.NOTING.getIndex();
            result[index]++;
        }

        return result;
    }

    private int getIndexResult(int random, int target) {
        return (random == target) ? ResultStatus.STRIKE.getIndex() : ResultStatus.BALL.getIndex();
    }

    /**
     * 체크 결과 문자열 출력
     * @param result 체크결과로 받은 int 배열
     * @return 결과에 대한 문자열
     */
    public String print(int[] result) {
        if (result[ResultStatus.NOTING.getIndex()] == 3)
            return ResultStatus.NOTING.getName();

        StringBuilder stb = new StringBuilder();
        if (result[ResultStatus.STRIKE.getIndex()] > 0)
            stb.append(result[ResultStatus.STRIKE.getIndex()]).append(ResultStatus.STRIKE.getName()).append(" ");
        if (result[ResultStatus.BALL.getIndex()] > 0)
            stb.append(result[ResultStatus.BALL.getIndex()]).append(ResultStatus.BALL.getName());

        return stb.toString().trim();
    }
}
