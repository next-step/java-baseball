package baseball;

import java.util.Scanner;

public class Game {

    final Target target;
    final Scanner scanner;

    public Game(Scanner scanner) {
        target = new Target();
        System.out.println(target.value);
        this.scanner = scanner;
    }

    public void start() {
        Play play = playInteractive(scanner);
        while (!play.hasWin()) {
            play = playInteractive(scanner);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private Play playInteractive(Scanner scan) {
        System.out.print("숫자를 입력하세요 : ");
        String trialSource = scan.nextLine();
        Trial trial = Trial.of(trialSource);
        Play play = Play.of(target, trial);
        System.out.println(play.getHint());
        return play;
    }
}
