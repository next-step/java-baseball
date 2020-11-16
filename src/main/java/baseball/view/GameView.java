package baseball.view;

import baseball.domain.Hint;

public interface GameView {
    String inputNumber();
    void showHint(Hint hint);
    void showEndGuide();
}
