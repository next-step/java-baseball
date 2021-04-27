package baseball.domain;

public class Hitter {

    private Numbers numbers;

    public Hitter(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers numbers() {
        return this.numbers;
    }
}
