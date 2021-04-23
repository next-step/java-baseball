package domain;

import java.util.Objects;

public class Strike {

    private static final int STRIKE_ZERO = 0;
    private static final int STRIKE_SIZE = 3;

    private final int strike;

    private Strike(int strike) {
        validateStrike(strike);
        this.strike = strike;
    }

    public static Strike of(int strike) {
        return new Strike(strike);
    }

    private void validateStrike(int strike) {
        if(strike < STRIKE_ZERO || strike > STRIKE_SIZE){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Strike strike1 = (Strike) o;
        return strike == strike1.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike);
    }

    @Override
    public String toString() {
        return String.valueOf(strike);
    }
}
