package baseball;

import baseball.domain.Score;

import java.util.Scanner;

public class Console {

    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }

    public void play() {
    }

    public boolean result(Score score) {
        if (score.getStrike() == 3) {
            return true;
        }
        return false;
    }

    public void print(Score score) {
        StringBuilder result = new StringBuilder();
        if (score.getStrike() > 0)
            result.append(score.getStrike()).append(" 스트라이크 ");
        if (score.getBall() > 0 && score.getBall() < 4)
            result.append(score.getBall()).append(" 볼");
        System.out.println(result.toString().trim());
        if (score.getStrike() == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

}
