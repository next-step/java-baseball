package domain;

import java.util.Objects;

public class ResultCondition {
    private final boolean sameNumber;
    private final boolean sameNumberAndPosition;


    public ResultCondition(boolean sameNumber, boolean sameNumberAndPosition) {
        this.sameNumber = sameNumber;
        this.sameNumberAndPosition = sameNumberAndPosition;
    }

    public static ResultCondition of(boolean sameNumber, boolean sameNumberAndPosition) {
        return new ResultCondition(sameNumber, sameNumberAndPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ResultCondition) {
            ResultCondition other = (ResultCondition) o;
            return this.sameNumber == other.sameNumber && this.sameNumberAndPosition == other.sameNumberAndPosition;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameNumber, sameNumberAndPosition);
    }
}
