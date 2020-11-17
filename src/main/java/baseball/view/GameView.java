package baseball.view;

import baseball.domain.Hint;

/**
 * 야구 게임에서 입/출력을 역할을 하는 인터페이스
 *
 * @author  Yonggu Han
 */
public interface GameView {
    String inputNumber();
    void showHint(Hint hint);
    void showEndGuide();
}
