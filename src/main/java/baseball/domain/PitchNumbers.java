package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PitchNumbers {
    private final Set<PitchNumber> pitchNumbers;

    private PitchNumbers(List<PitchNumber> pitchNumbers) {
        this.pitchNumbers = new LinkedHashSet<>(pitchNumbers);
    }

    public static PitchNumbers of(String pitchNumbers) {
        int index = 0;
        List<PitchNumber> numbers = new ArrayList<>();
        while (index < pitchNumbers.length()) {
            numbers.add(PitchNumber.of(String.valueOf(pitchNumbers.charAt(index++))));
        }
        return new PitchNumbers(numbers);
    }

    public static PitchNumbers of(List<PitchNumber> pitchNumbers) {
        return new PitchNumbers(pitchNumbers);
    }
}
