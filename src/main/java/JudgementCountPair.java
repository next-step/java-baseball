import java.util.HashMap;
import java.util.Map;

public class JudgementCountPair {

    public static final int DEFAULT_VALUE = 0;
    public static final int MATCH_COUNT = 1;

    private final Map<Judgements, Integer> judgementCounts;

    public JudgementCountPair() {
        this.judgementCounts = new HashMap<>();
    }

    public JudgementCountPair putJudgement(Judgements judgement) {
        judgementCounts.put(judgement, addMatchCount(judgement));
        return this;
    }

    private int addMatchCount(Judgements judgement) {
        return judgementCounts.getOrDefault(judgement, DEFAULT_VALUE) + MATCH_COUNT;
    }

    public Integer get(Judgements judgement) {
        return judgementCounts.get(judgement);
    }
}
