package baseball.ui.impl;

import baseball.ui.UiSystem;

/**
 * 테스트 & 디버깅용으로 사용하는 UI 시스템 Fake 객체
 */
public class TestUiSystem implements UiSystem {

    // test only
    private String gameInput;
    private String displayData;

    public String getGameInput() {
        return gameInput;
    }

    public void setGameInput(String gameInput) {
        this.gameInput = gameInput;
    }

    public String getDisplayData() {
        return displayData;
    }

    public void setDisplayData(String displayData) {
        this.displayData = displayData;
    }

    @Override
    public String gameInput() {
        return gameInput;
    }

    @Override
    public void display(String data) {
        displayData = data;
    }

}
