package com.tistory.javapanda.baseball.view;

import com.tistory.javapanda.baseball.enums.BaseballMessage;

public class BaseBallView {

    public void inputNumbersMessage() {
        System.out.println(BaseballMessage.INPUT_MESSAGE.getMessage());
    }

    public void finishMessage() {
        System.out.println(BaseballMessage.FINISH_MESSAGE.getMessage());
    }
}
