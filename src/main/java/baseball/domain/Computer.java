package baseball.domain;

import java.util.Objects;

public class Computer {

    private final BallNumbers numbers;

    public Computer(BallNumbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(numbers, computer.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
