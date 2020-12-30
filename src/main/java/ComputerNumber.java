public class ComputerNumber {

    private int lengthOfNumber;
    private int number;
    private BaseballGameNumberChecker checker;

    public ComputerNumber(int lengthOfNumber) {
        this.lengthOfNumber = lengthOfNumber;
        checker = new BaseballGameNumberChecker(lengthOfNumber);
    }

    public int getNumber() {
        while (!checker.isCorrect(this.number)) {
            this.number = this.makeRandomNumber();
        }
        return this.number;
    }

    public int makeRandomNumber() {
        return (int)((Math.random() - 1) * Math.pow(10, lengthOfNumber));
    }

}
