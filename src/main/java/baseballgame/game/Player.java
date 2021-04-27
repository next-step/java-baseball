package baseballgame.game;

import baseballgame.view.InputConverter;
import baseballgame.view.InputScanner;

public class Player {

    private static final String PLEASE_INPUT_GAME_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_FINISHED = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RERUN_FORMAT = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";
    private static final String RERUN_COMMAND = "1";
    private static final String FINISH_COMMAND = "2";

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

    public boolean wantToRerun() {
        System.out.println(String.format(ASK_RERUN_FORMAT, RERUN_COMMAND, FINISH_COMMAND));
        return InputConverter.convertToRerunCommand(InputScanner.read(), RERUN_COMMAND, FINISH_COMMAND);
    }
}
