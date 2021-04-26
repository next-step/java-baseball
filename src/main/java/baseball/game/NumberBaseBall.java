package baseball.game;

import baseball.game.enums.Command;
import baseball.game.ground.Ground;
import baseball.game.referee.Referee;
import baseball.ui.UiSystem;

public class NumberBaseBall {

    private static final String GUIDE_MESSAGE = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요",
            Command.AGAIN.getCommand(),
            Command.EXIT.getCommand());

    private final UiSystem uiSystem;
    private final Ground ground;
    private final Referee referee;

    public NumberBaseBall(UiSystem uiSystem) {
        this.uiSystem = uiSystem;
        this.ground = new Ground(uiSystem);
        this.referee = new Referee();
    }

    public void run() {

        boolean isRunning = true;
        while (isRunning) {

            referee.playBall(ground);
            isRunning = onEventInput();
        }
        uiSystem.display("게임을 종료합니다");
    }

    private boolean onEventInput() {

        while (true) {
            uiSystem.display(GUIDE_MESSAGE);

            String inputString = uiSystem.gameInput().trim().toLowerCase();
            Command cmd = Command.parse(inputString);
            if (Command.canAgain(cmd)) {
                return true;
            }

            if (Command.canExit(cmd)) {
                return false;
            }
            uiSystem.display(Command.UNKNOWN.name());
        }
    }
}
