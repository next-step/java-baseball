package baseballgame.game;

import baseballgame.view.InputConverter;
import baseballgame.view.InputScanner;

public class Player {

    private static final String PLEASE_INPUT_GAME_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_FINISHED = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void play(Game game) {
        boolean playing = true;
        while (playing) {
            System.out.print(PLEASE_INPUT_GAME_NUMBER);
            final GameNumber inputGameNumber = InputConverter.convertToGameNumber(InputScanner.read());
            final GameResult gameResult = game.submit(inputGameNumber);
            System.out.println(gameResult.printHint());
            playing = !gameResult.isAnswer();
        }
        System.out.println(GAME_FINISHED);
    }

}
