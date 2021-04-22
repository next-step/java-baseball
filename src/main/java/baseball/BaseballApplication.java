package baseball;

import baseball.view.BaseballView;

public class BaseballApplication {
    public BaseballApplication() {
    }

    public static void main(String[] args) {
        BaseballView baseBallView = new BaseballView();
        baseBallView.start();
    }
}
