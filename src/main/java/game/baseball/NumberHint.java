package game.baseball;

public abstract class NumberHint {

    private final int count;
    private final String marking;

    public NumberHint(int count, String marking) {
        this.count = count;
        this.marking = marking;
    }

    public final int getCount() {
        return count;
    }

    public final String getMarking() {
        return count + marking;
    }
}
