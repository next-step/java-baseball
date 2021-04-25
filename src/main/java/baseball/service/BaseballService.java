package baseball.service;

import baseball.domain.BallNumbers;
import baseball.domain.PitchingResultStatus;
import baseball.domain.dto.BaseballResultResponse;
import baseball.domain.strategy.BaseballGenerator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class BaseballService {
    public static final int DEFAULT_VALUE = 0;
    private final BaseballGenerator baseballGenerator;

    public BaseballService(final BaseballGenerator baseballGenerator) {
        this.baseballGenerator = baseballGenerator;
    }

    public BallNumbers generateComputedNumbers() {
        return baseballGenerator.generate();
    }

    public BaseballResultResponse matchesBallNumbers(BallNumbers computedNumbers, List<Integer> inputNumbers) {
        BallNumbers userBallNumber = BallNumbers.of(inputNumbers);
        Map<PitchingResultStatus, Integer> pitchingResultMap = matchingAndSave(computedNumbers, userBallNumber);

        return BaseballResultResponse.of(pitchingResultMap);
    }

    private Map<PitchingResultStatus, Integer> matchingAndSave(BallNumbers computedNumbers, BallNumbers userNumbers) {
        Map<PitchingResultStatus, Integer> pitchingResultMap = getPitchingResultMapWithDefault();

        for (int index = 0; index < userNumbers.size(); index++) {
            PitchingResultStatus resultStatus = computedNumbers.getPitchingResultStatus(userNumbers.get(index), index);
            Integer count = pitchingResultMap.get(resultStatus);

            pitchingResultMap.put(resultStatus, ++count);
        }

        return pitchingResultMap;
    }

    private EnumMap<PitchingResultStatus, Integer> getPitchingResultMapWithDefault() {
        EnumMap<PitchingResultStatus, Integer> map = new EnumMap<>(PitchingResultStatus.class);

        for (PitchingResultStatus status : PitchingResultStatus.values()) {
            map.put(status, DEFAULT_VALUE);
        }

        return map;
    }
}
