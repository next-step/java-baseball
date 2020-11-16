package baseball;

import baseball.game.BaseBall;
import baseball.game.BaseBallValueGenerator;
import baseball.input.BaseBallInputer;

public class Main {
    public static void main(String[] args) {
        boolean isExit = true;
        BaseBall baseBall = new BaseBall(BaseBallValueGenerator.generateValue());

        while (isExit) {
            System.out.print("숫자를 입력해주세요 : ");
            BaseBallInputer.input(System.in);
            isExit = false;
        }
    }
}
