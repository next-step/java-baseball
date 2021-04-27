package baseball;

import baseball.domain.*;
import baseball.util.ListConverter;
import baseball.view.ReceivingBaseballNumber;
import baseball.view.ReceivingPlayAgainAnswer;
import baseball.view.ResultScreen;

import java.util.List;

public class BaseballGame {
    public static final int RESTART_CODE = 1;
    public static final int EXIT_CODE = 2;

    private BaseballNumberGenerator baseballNumberGenerator;
    private BaseballNumberValidator baseballNumberValidator;
    private GameChecker gameChecker;

    private ReceivingBaseballNumber receivingBaseballNumber;
    private ReceivingPlayAgainAnswer receivingPlayAgainAnswer;
    private ResultScreen resultScreen;

    public BaseballGame(BaseballNumberGenerator baseballNumberGenerator,
                        BaseballNumberValidator baseballNumberValidator,
                        GameChecker gameChecker, ReceivingBaseballNumber receivingBaseballNumber,
                        ReceivingPlayAgainAnswer receivingPlayAgainAnswer, ResultScreen resultScreen){
        this.baseballNumberGenerator = baseballNumberGenerator;
        this.baseballNumberValidator = baseballNumberValidator;
        this.gameChecker = gameChecker;
        this.receivingBaseballNumber = receivingBaseballNumber;
        this.receivingPlayAgainAnswer = receivingPlayAgainAnswer;
        this.resultScreen = resultScreen;
    }

    public void play() {
        do{
            BaseballNumberGroup computerNumbers = baseballNumberGenerator.generate();
            play(computerNumbers);
        }while(!isExit());
    }

    private void play(BaseballNumberGroup computerNumbers){
        GameResult gameResult;
        do{
            BaseballNumberGroup playerNumbers = BaseballNumberGroup.of(receiveInput());
            gameResult = gameChecker.check(playerNumbers, computerNumbers);
            resultScreen.view(gameResult);
        }while (!gameResult.isAllStrikes());
    }

    private List<Integer> receiveInput(){
        List<Integer> playerNumbers;
        do{
            String receivedNumbers = receivingBaseballNumber.receiveBaseballNumber();
            playerNumbers = ListConverter.convert(receivedNumbers);
        }while (!baseballNumberValidator.isValid(playerNumbers));
        return playerNumbers;
    }

    private boolean isExit(){
        return EXIT_CODE == receivingPlayAgainAnswer.receivePlayAgainAnswer();
    }
}
