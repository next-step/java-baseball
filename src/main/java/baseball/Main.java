package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Referee referee;
    private NumberGenerator numberGenerator;
    private Scanner sc = new Scanner(System.in);

    private Main() {//prevent Default Constructor

    }

    public Main(Referee referee, NumberGenerator numberGenerator) {
        this.referee = referee;
        this.numberGenerator = numberGenerator;

    }


    public void start() {
        numberGenerator.getNotDuplicatedEachHundredNumber();
        int inputedNumberByPlayer = getInputNumberByPlayer();

    }

    private int getInputNumberByPlayer() throws InputMismatchException {
        int number = 0;
        try {
            System.out.println("세자리 숫자를 입력해주세요 =>");
            number = sc.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            sc = new Scanner(System.in);
            getInputNumberByPlayer();
        } finally {
            number = number > 99 && number < 1000 ? number : getInputNumberByPlayer();
        }
        return number;
    }
}
