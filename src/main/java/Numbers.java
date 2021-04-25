import java.util.List;

public class Numbers {
    private final List<Integer> gameNumbers;

    public Numbers(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public int size() {
        return this.gameNumbers.size();
    }

    public boolean strike(List<Integer> userNumbers) {
        return false;
    }
}
