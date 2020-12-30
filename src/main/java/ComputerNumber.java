public class ComputerNumber {

    private int lengthOfNumber;
    private BaseballGameNumberChecker checker;

    public ComputerNumber(int lengthOfNumber) {
        this.lengthOfNumber = lengthOfNumber;
        checker = new BaseballGameNumberChecker(lengthOfNumber);
    }

    public int getNumber() {
        int number = 0;
        while (!checker.isCorrect(number)) {
            number = this.makeRandomNumber();
        }
        return number;
    }

    public int makeRandomNumber() {
        return (int)(Math.random() * Math.pow(10, lengthOfNumber));
    }

}
