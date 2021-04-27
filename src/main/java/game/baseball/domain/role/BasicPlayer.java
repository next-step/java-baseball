package game.baseball.domain.role;

import utils.InputUtil;

public class BasicPlayer implements Player{
    public String inputNumber() {
        String input = InputUtil.input();
        return input;
    }
}
