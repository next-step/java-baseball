package baseball;

public class BaseballService {

    public Number createRandomNumber() {

        int firstNumber = (int)Math.floor(Math.random() * (9 - 1) + 1);
        int secondNumber = (int)Math.floor(Math.random() * (9 - 1) + 1);
        int thirdNumber = (int)Math.floor(Math.random() * (9 - 1) + 1);

        while (secondNumber == firstNumber) {
            secondNumber = (int)Math.floor(Math.random() * (9 - 1) + 1);
        }

        while (thirdNumber == firstNumber || thirdNumber == secondNumber) {
            thirdNumber = (int)Math.floor(Math.random() * (9 - 1) + 1);
        }

        return new Number(firstNumber, secondNumber, thirdNumber);

    }

    public boolean validateInputValue(int inputValue) {

        int firstValue = readNumberByPosition(inputValue, 1);
        int secondValue = readNumberByPosition(inputValue, 2);
        int thirdValue = readNumberByPosition(inputValue, 3);

        if (String.valueOf(inputValue).contains("0")) {
            System.out.println("숫자값에 0은 포함될 수 없습니다.");
            return false;
        }

        if (inputValue < 111 || inputValue > 999) {
            System.out.println("잘못된 숫자가 입력되었습니다.");
            return false;
        }

        if (firstValue == secondValue || secondValue == thirdValue || thirdValue == firstValue) {
            System.out.println("중복된 숫자가 입력되었습니다.");
            return false;
        }

        return true;

    }

    public int readNumberByPosition(int number, int position) {

        if (position == 1) {
            return number / 100;
        }

        if (position == 2) {
            return (number % 100) / 10;
        }

        return number % 10;

    }

    public void compareNumber(Referee referee, Number generateNumber, int inputValue) {

        compareFirstNumber(referee, generateNumber, readNumberByPosition(inputValue, 1));
        compareSecondNumber(referee, generateNumber, readNumberByPosition(inputValue, 2));
        compareThirdNumber(referee, generateNumber, readNumberByPosition(inputValue, 3));

    }

    public void compareFirstNumber(Referee referee, Number generateNumber, int inputValue) {

        if (inputValue == generateNumber.getFirstNumber()) {
            referee.addStrike();
            return;
        }

        if (inputValue == generateNumber.getSecondNumber() || inputValue == generateNumber.getThirdNumber()) {
            referee.addBall();
            return;
        }

    }

    public void compareSecondNumber(Referee referee, Number generateNumber, int inputValue) {

        if (inputValue == generateNumber.getSecondNumber()) {
            referee.addStrike();
            return;
        }

        if (inputValue == generateNumber.getFirstNumber() || inputValue == generateNumber.getThirdNumber()) {
            referee.addBall();
            return;
        }

    }

    public void compareThirdNumber(Referee referee, Number generateNumber, int inputValue) {

        if (inputValue == generateNumber.getThirdNumber()) {
            referee.addStrike();
            return;
        }

        if (inputValue == generateNumber.getFirstNumber() || inputValue == generateNumber.getSecondNumber()) {
            referee.addBall();
            return;
        }

    }

    public String setResult(Referee referee) {

        String result = "";

        if (referee.getStrike() != 0) {
            result = result + referee.getStrike() + "스트라이크 ";
        }

        if (referee.getBall() != 0) {
            result = result + referee.getBall() + "볼 ";
        }

        if (result.equals("")) {
            result = "낫싱";
        }

        return result;

    }

}
