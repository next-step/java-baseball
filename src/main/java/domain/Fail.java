package domain;

import view.ResultView;

public class Fail extends GameRule {

    private static Fail instance = new Fail();

    public static Fail getInstance() {
        return instance;
    }

    public boolean isRule(int strikeNum, int ballNum) {
        if (strikeNum == 0 && ballNum == 0) {
            ResultView.fail();
            return true;
        }
        return false;
    }
}
