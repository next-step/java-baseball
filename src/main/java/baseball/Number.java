package baseball;

public class Number {

    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Number() {

        firstNumber = (int) Math.floor(Math.random()*(9-1)+1);
        secondNumber = (int) Math.floor(Math.random()*(9-1)+1);
        thirdNumber = (int) Math.floor(Math.random()*(9-1)+1);

        while (secondNumber == firstNumber) {
            secondNumber = (int) Math.floor(Math.random()*(9-1)+1);
        }

        while (thirdNumber == firstNumber || thirdNumber == secondNumber) {
            thirdNumber = (int) Math.floor(Math.random()*(9-1)+1);
        }
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

}