package baseball.domain;

import java.util.Map;
import java.util.Set;

public class GameNumberPackage {
    private final Map<GameNumber, Integer> numbers;

    public GameNumberPackage(Map<GameNumber, Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean containsGameNumber(GameNumber gameNumber) {
        return numbers.containsKey(gameNumber);
    }

    public int getGameNumberIndex(GameNumber gameNumber) {
        return numbers.getOrDefault(gameNumber, -1);
    }

    public int size() {
        return numbers.size();
    }

    public Set<GameNumber> getNumbers() {
        return numbers.keySet();
    }
}
