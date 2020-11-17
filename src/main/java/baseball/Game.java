package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    private Scanner scanner;
    private Computer computer;
    private Result result;

    public Game() {
        init();
    }

    private void init() {
        this.scanner = new Scanner(System.in);
        this.computer = new Computer();
        this.result = new Result();
    }

    public void run() {
        int input = input();
        Checker.checkStrikeOrBall(input, computer.getAnswer(), result);
        System.out.println(result.getResultMessage());
    }

    private int input() {
        System.out.print("숫자를 입력해주세요 : ");
        int input = Integer.parseInt(scanner.nextLine());
        if (!validInput(input)) {
            System.out.print("유효하지 않은 정답을 입력하셨습니다. 다시 ");
            return input();
        }
        return input;
    }

    private boolean validInput(int input) {
        if ((input >= 111 && input <= 999) && Pattern.matches("^[1-9]*$", Integer.toString(input))) {
            return true;
        }
        return false;
    }
}
