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
}
