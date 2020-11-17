package game.baseball.number.participants;

import game.baseball.number.utils.HelperTexts;
import game.baseball.number.utils.ConsoleInputUtil;

class Hitter {

    String hit() {
        return ConsoleInputUtil.input(HelperTexts.INPUT_NUMBER);
    }
}
