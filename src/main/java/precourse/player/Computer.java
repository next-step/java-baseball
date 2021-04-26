package precourse.player;

import precourse.baseball.BaseballGenerator;
import precourse.baseball.Baseballs;
import precourse.game.BaseballGameResult;
import precourse.game.BaseballNumberString;
import precourse.game.UserChoice;

public class Computer {

    private final BaseballGenerator generator = new BaseballGenerator();

    public Baseballs pickRandomBaseballs() {
        return generator.createRandomBaseballs();
    }

    public Baseballs pickBaseballs(BaseballNumberString baseballNumber) {
        return generator.createBaseballs(baseballNumber.numberString());
    }

    public BaseballGameResult getBaseballGameResult(Baseballs computerBaseballs, Baseballs userBaseballs) {
        return new BaseballGameResult(computerBaseballs, userBaseballs);
    }

    public BaseballNumberString receiveAnswer(User user) {
        try {
            String answer = user.answer();
            return new BaseballNumberString(answer);
        } catch (IllegalArgumentException e) {
            return receiveAnswer(user);
        }
    }

    public UserChoice receiveChoice(User user) {
        try {
            String answer = user.answer();
            return new UserChoice(answer);
        } catch (IllegalArgumentException e) {
            return receiveChoice(user);
        }
    }

}
