package baseball.view;

public interface BaseballGameView {

    void showBallCountMessage(int[] result);

    void showAskingForInputMessage();

    boolean showFinishMessage(boolean roundFinished);
}
