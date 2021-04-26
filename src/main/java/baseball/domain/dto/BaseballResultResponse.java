package baseball.domain.dto;

import baseball.domain.PitchingResultStatus;
import baseball.exceptions.InvalidBallNumbersSizeException;

import java.util.Collection;
import java.util.Map;

import static baseball.domain.PitchingResultStatus.*;

public class BaseballResultResponse {
    public static final int DEFAULT_VALUE = 0;
    private final Map<PitchingResultStatus, Integer> pitchingResult;
    private final boolean allStrike;
    private final boolean nothing;

    public BaseballResultResponse(Map<PitchingResultStatus, Integer> pitchingResult, boolean allStrike, boolean nothing) {
        this.pitchingResult = pitchingResult;
        this.allStrike = allStrike;
        this.nothing = nothing;
    }

    public static BaseballResultResponse of(Map<PitchingResultStatus, Integer> pitchingResult) {
        validateParamMap(pitchingResult);
        return new BaseballResultResponse(pitchingResult, isAllStrikeBool(pitchingResult), isAllNothing(pitchingResult));
    }

    private static void validateParamMap(Map<PitchingResultStatus, Integer> pitchingResult) {
        int sum = 0;

        for (Integer value : pitchingResult.values()) {
            sum += value;
        }

        if (sum != 3) {
            throw new InvalidBallNumbersSizeException();
        }
    }

    private static boolean isAllNothing(Map<PitchingResultStatus, Integer> pitchingResult) {
        return pitchingResult.getOrDefault(NOTHING, DEFAULT_VALUE) == 3;
    }

    private static boolean isAllStrikeBool(Map<PitchingResultStatus, Integer> pitchingResult) {
        return pitchingResult.getOrDefault(STRIKE, DEFAULT_VALUE) == 3;
    }

    public Map<PitchingResultStatus, Integer> getPitchingResult() {
        return pitchingResult;
    }

    public boolean isAllStrike() {
        return allStrike;
    }

    public boolean isNothing() {
        return nothing;
    }
}
