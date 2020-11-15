package baseballgame;

import java.util.Objects;

public class InputNumber {
    Integer firstNumber;
    Integer secondNumber;
    Integer thirdNumber;

    public InputNumber(Integer firstNumber, Integer secondNumber, Integer thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumber number = (InputNumber) o;
        return Objects.equals(firstNumber, number.firstNumber) &&
                Objects.equals(secondNumber, number.secondNumber) &&
                Objects.equals(thirdNumber, number.thirdNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber, thirdNumber);
    }
}
