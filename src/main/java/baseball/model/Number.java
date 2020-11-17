package baseball.model;

import java.util.Objects;

public class Number implements Comparable<Number> {

    private final String number;

    public Number(final String number){
        this.number = number;
    }

    @Override
    public int compareTo(final Number o) {
        return number.compareTo(o.number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Number)) {
            return false;
        }

        final Number that = (Number) o;
        if(number.toString().compareTo(that.number.toString()) == 0) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
