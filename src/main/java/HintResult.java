import java.util.LinkedHashMap;
import java.util.Map;

public class HintResult {

    private final int DEFAULT_COUNT = 0;
    private final int INCREASE_COUNT = 1;

    private Map<Hint, Integer> hintResult = new LinkedHashMap<>();

    public HintResult() {
        setDefaultHintResult();
    }

    private void setDefaultHintResult() {
        hintResult.put(Hint.STRIKE, DEFAULT_COUNT);
        hintResult.put(Hint.BALL, DEFAULT_COUNT);
    }

    public void increaseStrikeCount() {
        hintResult.put(Hint.STRIKE, hintResult.get(Hint.STRIKE) + INCREASE_COUNT);
    }

    public void increaseBallCount() {
        hintResult.put(Hint.BALL, hintResult.get(Hint.BALL) + INCREASE_COUNT);
    }

    public String getResultMessage() {
        if (isNothing()) {
            return Hint.NOTHING.getKorean();
        }

        int strikeCount = hintResult.get(Hint.STRIKE);
        int ballCount = hintResult.get(Hint.BALL);
        String strikeMessage = strikeCount == 0 ? "" : strikeCount + " " + Hint.STRIKE.getKorean() + " ";
        String ballMessage = ballCount == 0 ? "" : ballCount + Hint.BALL.getKorean();

        return strikeMessage + ballMessage;
    }

    private boolean isNothing() {
        return hintResult.get(Hint.STRIKE) == DEFAULT_COUNT && hintResult.get(Hint.BALL) == DEFAULT_COUNT;
    }
}
