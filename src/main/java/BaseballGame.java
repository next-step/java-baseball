import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {

    public final int NUMBER_SIZE = 3;

    private BaseballGameHint hint;
    private ArrayList<Integer> correctNumbers;
    private ArrayList<Integer> inputNumbers;

    public BaseballGameHint getHint() {
        return hint;
    }

    public ArrayList<Integer> getCorrectNumbers() {
        return correctNumbers;
    }

    public void setCorrectNumbers(ArrayList<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
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

    public void calculateHint() {
        this.hint = new BaseballGameHint(this.correctNumbers, this.inputNumbers);
        Strike strike = new Strike();
        Ball ball = new Ball();
        Nothing nothing = new Nothing();
        this.hint.create(strike, ball, nothing);
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

    private boolean isCorrect() {
        return this.hint.getStrike().getCount() == NUMBER_SIZE;
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

    public void setCorrectNumbers() {
        BaseballNumberMaker numberMaker = new BaseballNumberMaker();
        this.correctNumbers = numberMaker.makeNonDuplicateRandomNumber();
    }

    public void start() {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        setInputNumbers(scanner.next());
        calculateHint();
        printHint();
        if (isCorrect()) {
            gameOver();
            return;
        }
        start();
    }

}