package baseball.domain;

public class IncrementsNumber implements OneDigitNumber {
    private int number = 1;

    @Override
    public int value() {
        return number++;
    }
}
