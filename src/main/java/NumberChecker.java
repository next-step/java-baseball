import result.Ball;
import result.Strike;

public class NumberChecker {

    private RandomNumber randomNumber;
    private int numberLength;
    private NumberCheckResult numberCheckResult;

    public NumberChecker(int numberLength, RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
        this.numberLength = numberLength;
    }

    public NumberCheckResult check(String numbers) {
        this.numberCheckResult = new NumberCheckResult(numberLength);
        int index = 0;
        while (index != numberLength) {
            checkStrike(numbers.split("")[index], index);
            index++;
        }
        return this.numberCheckResult;
    }

    private void checkStrike(String number, int index) {
        if (randomNumber.get(index).equals(number)) {
            this.numberCheckResult.add(new Strike());
            return;
        }
        checkBall(number);
    }

    private void checkBall(String number) {
        if (randomNumber.contain(number)) {
            this.numberCheckResult.add(new Ball());
        }
    }
}
