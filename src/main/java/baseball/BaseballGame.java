package baseball;

import customtypes.GameResult;

public class BaseballGame {
    private BaseballReferee baseballReferee;
    private RandomGenerator randomGenerator;

    private String computerInput;

    public BaseballGame(
            BaseballReferee baseballReferee,
            RandomGenerator randomGenerator) {
        this.baseballReferee = baseballReferee;
        this.randomGenerator = randomGenerator;

        // [ 210425 hsoh ] Baseball game must have 3 trial, so pass digitCount parameter as 3
        this.computerInput = this.randomGenerator.getRandomDigits(3);
    }

    public GameResult play(String playerInput){
        // TODO: Needs implement
        return GameResult.NONE;
    }
}
