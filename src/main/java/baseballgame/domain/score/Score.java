package baseballgame.domain.score;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Score {
    private static final int MIN = 1;
    private static final int MAX = 9;

    private static final int SCORE_LIMIT = 3;

    private final int hundredsPlace;
    private final int tensPlace;
    private final int onesPlace;

    private Score() {
        final List<Integer> integerList = createRandomScore();

        final int HUNDREDS_DIGIT = 0;
        final int TENS_DIGIT = 1;
        final int ONES_DIGIT = 2;

        this.hundredsPlace = integerList.get(HUNDREDS_DIGIT);
        this.tensPlace = integerList.get(TENS_DIGIT);
        this.onesPlace = integerList.get(ONES_DIGIT);
    }

    private List<Integer> createRandomScore() {
        final Set<Integer> integerSet = new HashSet<>();
        while (integerSet.size() < SCORE_LIMIT) {
            final int idx = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            integerSet.add(idx);
        }

        return new ArrayList<>(integerSet);
    }

    private Score(final int hundredsPlace, final int tensPlace, final int onesPlace) {
        this.hundredsPlace = hundredsPlace;
        this.tensPlace = tensPlace;
        this.onesPlace = onesPlace;
    }

    public static Score getRandomScore() {
        return new Score();
    }

    public static Score getGivenValueScore(final int hundredsPlace, final int tensPlace, final int onesPlace) {
        if (validateEachValueSize(hundredsPlace, tensPlace, onesPlace)) {
            throw new IllegalArgumentException();
        }

        if (equalsNotSameEachDigitValue(hundredsPlace, tensPlace, onesPlace)) {
            throw new IllegalArgumentException();
        }

        return new Score(hundredsPlace, tensPlace, onesPlace);
    }

    private static boolean equalsNotSameEachDigitValue(final int hundredsPlace, final int tensPlace, final int onesPlace) {
        return (hundredsPlace == tensPlace) || (tensPlace == onesPlace) || (hundredsPlace == onesPlace);
    }

    private static boolean validateEachValueSize(final int hundredsPlace, final int tensPlace, final int onesPlace) {
        return (MIN > hundredsPlace) || (hundredsPlace > MAX)
            || (MIN > tensPlace) || (tensPlace > MAX)
            | (MIN > onesPlace) || (onesPlace > MAX);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return getHundredsPlace() == score.getHundredsPlace() &&
            getTensPlace() == score.getTensPlace() &&
            getOnesPlace() == score.getOnesPlace();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHundredsPlace(), getTensPlace(), getOnesPlace());
    }

    public int getHundredsPlace() {
        return hundredsPlace;
    }

    public int getTensPlace() {
        return tensPlace;
    }

    public int getOnesPlace() {
        return onesPlace;
    }
}
