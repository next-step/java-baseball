import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {

    public final int NUMBER_SIZE = 3;

    private Hint hint = new Hint();
    private ArrayList<Integer> correctNumbers;
    private ArrayList<Integer> inputNumbers;

    public Hint getHint() {
        return hint;
    }

    public ArrayList<Integer> getCorrectNumbers() {
        return correctNumbers;
    }

    public ArrayList<Integer> getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumberString) {
        int length = inputNumberString.length();
        ArrayList<Integer> inputNumbers = new ArrayList<>(length);
        for (int i = 0; i < inputNumberString.length(); i++) {
            int number = Character.getNumericValue(inputNumberString.charAt(i));
            inputNumbers.add(number);
        }
        this.inputNumbers = inputNumbers;
    }

    private void setStrikeHint(BaseballHintMaker hintMaker) {
        Strike strike = new Strike();
        for (int index = 0; index < NUMBER_SIZE; index++) {
            hintMaker.getStrikeHint(index, strike);
        }
        this.hint.setStrike(strike);
    }

    private void setBallHint(BaseballHintMaker hintMaker) {
        Ball ball = new Ball();
        for (int index = 0; index < NUMBER_SIZE; index++) {
            hintMaker.getBallHint(index, ball);
        }
        this.hint.setBall(ball);
    }

    private void setNothingHint() {
        Strike strike = this.hint.getStrike();
        Ball ball = this.hint.getBall();
        Nothing nothing = new Nothing();
        if (strike.getCount() == 0 && ball.getCount() == 0) {
            nothing.add();
        }
        this.hint.setNothing(nothing);
    }

    public void printHint() {
        this.hint.getStrike().print();
        if (this.hint.getStrike().getCount() > 0 && this.hint.getBall().getCount() > 0) {
            System.out.print(" ");
        }
        this.hint.getBall().print();
        this.hint.getNothing().print();
        System.out.println();
    }

    private void checkCorrect() {
        if (this.hint.getStrike().getCount() == NUMBER_SIZE) {
            gameOver();
            return;
        }
        start();
    }

    private void gameOver() {
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 2) {
            return;
        }
        setCorrectNumbers();
        start();
    }

    public void setHint() {
        this.hint = new Hint();
        BaseballHintMaker hintMaker = new BaseballHintMaker(this.correctNumbers, this.inputNumbers);
        setStrikeHint(hintMaker);
        setBallHint(hintMaker);
        setNothingHint();
    }

    public void setCorrectNumbers() {
        BaseballNumberMaker numberMaker = new BaseballNumberMaker();
        this.correctNumbers = numberMaker.makeNonDuplicateRandomNumber();
    }

    public void setCorrectNumbers(ArrayList<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public void start() {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        setInputNumbers(scanner.next());
        setHint();
        printHint();
        checkCorrect();
    }

}