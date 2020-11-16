package baseball;

import baseball.constant.GameCommandType;
import baseball.domain.BaseballNumbers;
import baseball.domain.GameScore;
import baseball.exception.BizException;
import baseball.exception.BizExceptionType;
import baseball.util.BaseballUtil;
import baseball.util.MessageUtil;

import java.util.Scanner;

public class BaseballGame {

    private boolean isExit = false;
    private Scanner scanner = new Scanner(System.in);

    public void play() {
        while (!isExit) {
            doGame();
        }
    }

    public void doGame() {

        boolean isGameClear = false;
        String[] randomNumbers = BaseballUtil.getRandomNumbers();

        while (!isGameClear) {
            //유저 입력 텍스트를 받아 validation check 후 리턴
            BaseballNumbers baseballNumbers = receiveUserInputAndCheckValid();
            //게임 스코어 체크 및 프린트
            GameScore gameScore = checkGameScore(randomNumbers, baseballNumbers);
            //게임 클리어 여부 확인
            isGameClear = gameScore.isGameClear();
        }
        askExit();
    }

    public BaseballNumbers receiveUserInputAndCheckValid(){
        MessageUtil.printStartMessage();
        String inputText = scanner.nextLine();

        BaseballNumbers baseballNumbers = new BaseballNumbers(inputText);
        baseballNumbers.checkValidation();

        return baseballNumbers;
    }

    public GameScore checkGameScore(String[] randomNumbers, BaseballNumbers baseballNumbers){
        GameScore gameScore = new GameScore();
        gameScore.checkGameScore(randomNumbers, baseballNumbers.getNumbers());

        MessageUtil.printGameResult(gameScore);
        return gameScore;
    }

    public void askExit() {
        MessageUtil.printRetryAskMessage();
        String command = scanner.nextLine();

        //정해진 명령어 이외의 입력은 오류를 리턴한다.
        if (!GameCommandType.isExistType(command)) {
            throw new BizException(BizExceptionType.INVALID_COMMAND);
        }
        if (command.equals(GameCommandType.EXIT.getCommand())) {
            isExit = true;
        }
    }

}
