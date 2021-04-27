package playball.domain;

public class HintResult {
    private final Hint hint;
    private final Integer count;

    private HintResult(Hint hint, Integer count) {
        this.hint = hint;
        this.count = count;
    }

    public static HintResult of(Hint hint, Integer count) {
        return new HintResult(hint, count);
    }

    public Hint getHint() {
        return hint;
    }

    public Integer getCount() {
        return count;
    }
}
