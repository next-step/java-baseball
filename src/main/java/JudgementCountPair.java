import java.util.HashMap;
import java.util.Map;

public class JudgementCountPair {

    public static final int DEFAULT_VALUE = 0;
    public static final int MATCH_COUNT = 1;

    private final Map<Judgements, Integer> judgementCounts;

    public JudgementCountPair() {
        this.judgementCounts = new HashMap<>();
    }

    public JudgementCountPair(Map<Judgements, Integer> judgementCounts) {
        this.judgementCounts = judgementCounts;
    }

    public JudgementCountPair createAddedMatchCount(Judgements judgement) {
        Map<Judgements, Integer> mutablePair = new HashMap<>(judgementCounts);
        mutablePair.put(judgement, addMatchCount(judgement));

        return new JudgementCountPair(Map.copyOf(mutablePair));
    }

    private int addMatchCount(Judgements judgement) {
        return judgementCounts.getOrDefault(judgement, DEFAULT_VALUE) + MATCH_COUNT;
    }

    public Integer get(Judgements judgement) {
        return judgementCounts.get(judgement);
    }
}
