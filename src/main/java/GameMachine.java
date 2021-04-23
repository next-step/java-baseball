import java.util.LinkedHashSet;
import java.util.Set;

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
        if (randomSet.size() < RANDOM_VALUE_MAX_LENGTH) {
            throw new IllegalStateException("중복된 값이 존재합니다.");
        }
    }

    private void isRandomValue(int value) {
        if (value < 1 || value > 9)
            throw new IllegalArgumentException("랜덤 값은 1 ~ 9까지 수여야 합니다.");
    }
}
