package baseball;

import baseball.controller.BaseballController;

public class BaseballApplication {
    public static void main(String[] args){
        BaseballController baseballController = new BaseballController();
        baseballController.play();
    }

}
