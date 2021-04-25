package baseball.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PitchNumbers {
    private static final int MAX_PITCH_SIZE = 3;

    private final Set<PitchNumber> pitchNumbers;

    private PitchNumbers(List<PitchNumber> pitchNumbers) {
        validateOfSize(pitchNumbers);
        this.pitchNumbers = new LinkedHashSet<>(pitchNumbers);
        validateOfDuplicate();
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

    private void validateOfSize(List<PitchNumber> pitchNumbers) {
        if (pitchNumbers.size() != MAX_PITCH_SIZE) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }

    private void validateOfDuplicate() {
        if (pitchNumbers.size() != MAX_PITCH_SIZE) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }

    public int matchStrike(PitchNumbers comparePitchNumbers) {
        Iterator<PitchNumber> baseIterator = pitchNumbers.iterator();
        Iterator<PitchNumber> compareIterator = comparePitchNumbers.pitchNumbers.iterator();

        int count = 0;
        while (compareIterator.hasNext() && baseIterator.hasNext()) {
            count = baseIterator.next().equals(compareIterator.next()) ? count + 1 : count;
        }
        return count;
    }

    public int matchBall(PitchNumbers comparePitchNumbers) {
        Iterator<PitchNumber> baseIterator = pitchNumbers.iterator();
        Iterator<PitchNumber> compareIterator = comparePitchNumbers.pitchNumbers.iterator();

        int count = 0;
        while (compareIterator.hasNext() && baseIterator.hasNext()) {
            PitchNumber pitchNumber = compareIterator.next();
            count = !baseIterator.next().equals(pitchNumber)
                && pitchNumbers.contains(pitchNumber)
                ? count + 1
                : count;
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PitchNumbers that = (PitchNumbers)o;
        return Objects.equals(pitchNumbers, that.pitchNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitchNumbers);
    }
}
