package nextstep.precourse.controller;

import nextstep.precourse.domain.BallNumber;
import nextstep.precourse.domain.BallNumbers;
import nextstep.precourse.domain.BaseballGame;
import nextstep.precourse.domain.GameResult;
import nextstep.precourse.view.InputView;
import nextstep.precourse.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGameController {

    public void play(InputView inputView, OutputView outputView) {
        BaseballGame game = new BaseballGame();

        while(true) {
            game.init();

            String userNumberString = inputView.getNumber();
            BallNumbers userBallNumbers = makeBallNumbers(userNumberString);

            GameResult gameResult = game.play(userBallNumbers);

            outputView.showResult(gameResult);

            if(game.play(userBallNumbers).isThreeStrike()) {
                outputView.showCorrectMessage();
                if(inputView.getContinue() == 2) {
                    break;
                }
            }
        }

        game.exit();
    }

    private BallNumbers makeBallNumbers(String userNumberString) {
        Set<BallNumber> ballNumberSet = new HashSet<>();

        for(int i = 0; i < 3; i++) {
            ballNumberSet.add(new BallNumber(Integer.parseInt(String.valueOf(userNumberString.charAt(i))), i+1));
        }

        return new BallNumbers(ballNumberSet);
    }
}
