package domain;

public class ComputerBallNumber {

    private BaseBallNumbers computerBaseBallNumber;

    public ComputerBallNumber(BaseBallNumberGenerator randomNumberGenerator) {
        this.computerBaseBallNumber = new BaseBallNumbers(randomNumberGenerator);
    }

    public BaseBallNumbers getBallNumbers() {
        return computerBaseBallNumber;
    }
}
