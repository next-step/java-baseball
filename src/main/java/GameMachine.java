import java.util.LinkedHashSet;
import java.util.Set;

public class GameMachine {

    public final static int RANDOM_NUMBER_SIZE = 3;

    private final Set<Integer> randomSets = new LinkedHashSet<>();

    public static GameMachine of() {
        return new GameMachine();
    }

    public int getCurrentRandomSetSize() {
        return randomSets.size();
    }
}
