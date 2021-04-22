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
}
