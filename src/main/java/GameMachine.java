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
        String regExp = "^[0-9]";
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
}
