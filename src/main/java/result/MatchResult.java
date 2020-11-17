package result;

public abstract class MatchResult {

    private int count;
    private String name;

    public MatchResult(String name) {
        this.name = name;
    }

    public void plus() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return String.format("%d %s", count, name);
    }

}
