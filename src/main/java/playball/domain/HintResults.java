package playball.domain;

import java.util.Collections;
import java.util.List;

public class HintResults {

    private final List<HintResult> hintResults;

    private HintResults(List<HintResult> hintResults) {
        this.hintResults = hintResults;
    }

    public static HintResults of(List<HintResult> hintResults) {
        return new HintResults(hintResults);
    }

    public List<HintResult> getHintResults() {
        return Collections.unmodifiableList(hintResults);
    }
}
