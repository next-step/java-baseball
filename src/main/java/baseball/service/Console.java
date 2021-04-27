package baseball.service;

import baseball.domain.Score;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Console {

    private Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        Game game = new Game();

        while (true) {
            int number = getNumber();

            if (isOutOfRangeNumber(number)) {
                System.out.println("잘못된 숫자를 입력하였습니다. 다시 입력해주세요.");
                continue;
            }

            if (isDuplicateNumber(number)) {
                System.out.println("중복된 숫자를 입력하였습니다. 다시 입력해주세요.");
                continue;
            }
            Score score = game.play(number);
            print(score);

            if (isFinish(score)) return;
        }
    }

    private boolean isOutOfRangeNumber(int number) {
        return number < 100 || number > 999;
    }

    private boolean isDuplicateNumber(int number) {
        Set<Integer> sets = new HashSet<>();
        sets.add(number / 100);
        sets.add(number / 10 % 10);
        sets.add(number % 10);
        return sets.size() != 3;
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
