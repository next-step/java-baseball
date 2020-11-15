package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Referee referee;
    private NumberGenerator numberGenerator;
    private Scanner sc = new Scanner(System.in);

    private Game() {//prevent Default Constructor

    }

    public Game(Referee referee, NumberGenerator numberGenerator) {
        this.referee = referee;
        this.numberGenerator = numberGenerator;
    }


    public void start() {
        int userNumber = getInputNumberByPlayer();
        if (referee.isPlayerWin(userNumber)) {
            setFinishGame();
            return;
        }
        start();

    }

    private void setFinishGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int number = sc.nextInt();
        if (number == 1) {
            System.out.println("새로운 게임을 시작합니다");
            referee.setComputerNumber(numberGenerator.getNotDuplicatedEachHundredNumber());
            new Game(referee, numberGenerator).start();
            return;
        }
        System.out.println("게임을 종료합니다");


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
