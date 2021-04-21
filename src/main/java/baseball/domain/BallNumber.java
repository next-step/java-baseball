package baseball.domain;

import baseball.exception.InvalidateBallNumberException;

public class BallNumber {
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public BallNumber(int firstNumber, int secondNumber, int thirdNumber) throws Exception {
        if(isValidate()) {
            this.firstNumber = firstNumber;
            this.secondNumber = secondNumber;
            this.thirdNumber = thirdNumber;
        }
        throw new InvalidateBallNumberException(firstNumber + ", " + secondNumber + ", "  + thirdNumber);
    }

    public int getFirstNumber(){
        return this.firstNumber;
    }

    public int getSecondNumber() {
        return this.secondNumber;
    }

    public int getThirdNumber() {
        return this.thirdNumber;
    }

    private boolean isValidate() {
        if(this.firstNumber == this.secondNumber || this.firstNumber == this.thirdNumber || this.secondNumber == this.thirdNumber)
            return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BallNumber) {
            BallNumber ballNumber = (BallNumber) obj;
            return this.firstNumber == ballNumber.firstNumber &&
                    this.secondNumber == ballNumber.secondNumber &&
                    this.thirdNumber == ballNumber.thirdNumber;
        }
        return false;
    }

    @Override
    public String toString() {
        return "첫번째 숫자 : " + this.firstNumber + " " +
               "두번째 숫자 : " + this.secondNumber + " " +
               "세번째 숫자 : " + this.thirdNumber;
    }
}
