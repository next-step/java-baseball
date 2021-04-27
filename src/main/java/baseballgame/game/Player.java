package baseballgame.game;

import baseballgame.view.InputConverter;
import baseballgame.view.InputScanner;

public class Player {

    public void play(Game game) {
        System.out.print("숫자를 입력해주세요 : ");
        final GameNumber inputGameNumber = InputConverter.convertToGameNumber(InputScanner.read());
        final GameResult gameResult = game.submit(inputGameNumber);
        System.out.println(gameResult.printHint());
    }

}
