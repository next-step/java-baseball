package com.tistory.javapanda.baseball.view;

import com.tistory.javapanda.baseball.enums.BaseballMessage;
import com.tistory.javapanda.baseball.vo.BaseBallVo;

public class BaseBallView {

    public void inputNumbersMessage() {
        System.out.println(BaseballMessage.INPUT_MESSAGE.getMessage());
    }

    public void resultMessage(BaseBallVo baseBallVo) {
        String message = strikeMessage(baseBallVo) + ballMessage(baseBallVo);
        if(message.length() == 0) {
            message = "포볼";
        }
        System.out.println(message);
    }

    public String strikeMessage(BaseBallVo baseBallVo) {
        String message = "";
        if(baseBallVo.getStrike() > 0) {
            message = baseBallVo.getStrike() + "스트라이크 ";
        }
        return message;
    }

    public String ballMessage(BaseBallVo baseBallVo) {
        String message = "";
        if(baseBallVo.getBall() > 0) {
            message = baseBallVo.getBall() + "볼";
        }
        return message;
    }

    public void finishMessage() {
        System.out.println(BaseballMessage.FINISH_MESSAGE.getMessage());
    }
}
