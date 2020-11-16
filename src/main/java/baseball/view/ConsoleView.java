package baseball.view;

import baseball.domain.Game;
import baseball.domain.Hint;

import java.util.Scanner;

public class ConsoleView implements GameView {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    @Override
    public void showHint(Hint hint) {
        System.out.println(hint.toString());
    }

    @Override
    public void showEndGuide() {
        System.out.println(Game.BASEBALL_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
}
