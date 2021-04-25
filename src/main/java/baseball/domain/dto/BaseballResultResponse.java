package baseball.domain.dto;

import baseball.domain.PitchingResultStatus;

import java.util.Map;

public class BaseballResultResponse {
    public static final int DEFAULT_VALUE = 0;
    private final Map<PitchingResultStatus, Integer> pitchingResult;
    private final boolean allStrike;

    public BaseballResultResponse(Map<PitchingResultStatus, Integer> pitchingResult, boolean allStrike) {
        this.pitchingResult = pitchingResult;
        this.allStrike = allStrike;
    }

    public static BaseballResultResponse of(Map<PitchingResultStatus, Integer> pitchingResult) {
        return new BaseballResultResponse(pitchingResult, isAllStrikeBool(pitchingResult));
    }

    private static boolean isAllStrikeBool(Map<PitchingResultStatus, Integer> pitchingResult) {
        return pitchingResult.getOrDefault(PitchingResultStatus.STRIKE, DEFAULT_VALUE) == 3;
    }

    public Map<PitchingResultStatus, Integer> getPitchingResult() {
        return pitchingResult;
    }

    public boolean isAllStrike() {
        return allStrike;
    }
}
