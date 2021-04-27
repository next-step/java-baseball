package baseball.service;

import baseball.domain.Score;

import java.util.Scanner;

public class Console {

    private Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        Game game = new Game(123);

        while (true) {
            int number = getNumber();
            if (checkOutOfRangeNumber(number)) continue;

            Score score = game.play(number);
            print(score);
            if (isFinish(score)) return;
        }
    }

    private boolean checkOutOfRangeNumber(int number) {
        if (number < 100 || number > 999) {
            System.out.println("잘못된 숫자를 입력하였습니다. 다시 입력해주세요.");
            return true;
        }
        return false;
    }

    private int getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }

    private boolean isFinish(Score score) {
        return score.getStrike() == 3;
    }

    private void print(Score score) {
        StringBuilder result = new StringBuilder();
        if (score.getStrike() > 0)
            result.append(score.getStrike()).append(" 스트라이크 ");
        if (score.getBall() > 0 && score.getBall() < 4)
            result.append(score.getBall()).append(" 볼");
        if (score.getBall() == 4)
            result.append("낫싱");
        System.out.println(result.toString().trim());
        if (score.getStrike() == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

}
