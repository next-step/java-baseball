package baseball.game.pitcher;

import baseball.game.gameball.GameBall;
import baseball.game.gameball.validatitor.InputStringValidator;
import baseball.ui.UiSystem;

/**
 * 피쳐(사용자)
 * 시스템 입력을 받아 값을 전달한다
 */
public class Pitcher {

    private final UiSystem uiSystem;

    public Pitcher(UiSystem uiSystem) {
        this.uiSystem = uiSystem;
    }

    public String throwing() {
        GameBall gameBall = GameBall.create(getInputNumber());
        return gameBall.toString();
    }

    /**
     * 사용자 입력에서 사용할 메시지(숫자)를 가져온다
     *
     * @return 입력 받은 숫자
     */
    private int getInputNumber() {
        while (true) {
            uiSystem.display("숫자를 입력해 주세요: ");
            String inputString = uiSystem.gameInput();
            if (!InputStringValidator.isSatisfied(inputString)) {
                uiSystem.display("올바르지 않은 입력입니다. 다시 입력해 주세요");
                continue;
            }

            return Integer.parseInt(inputString);
        }
    }
}
