package baseball;

import baseball.configuration.BaseballConfiguration;
import baseball.domain.BaseballNumbers;
import baseball.domain.GameScore;
import baseball.util.BaseballUtil;
import java.util.Scanner;

public class BaseballGame {

    public boolean isGame = true;
    private Scanner scanner = new Scanner(System.in);

    public void play(){
        //완전 종료가 될때까지
        doGame();

    }
    public void doGame(){

        //3개 맞출 때까지
        boolean isGameClear = false;
        String[] randomNumbers = BaseballUtil.getRandomNumbers();

        while (!isGameClear) {
            System.out.println(BaseballConfiguration.MESSAGE_REQUIRED_NUMBER);

            String inputText = scanner.nextLine();

            BaseballNumbers baseballNumbers = new BaseballNumbers(inputText);
            baseballNumbers.checkValidation();

            GameScore gameScore = new GameScore();
            gameScore.checkGameScore(randomNumbers, baseballNumbers.getNumbers());

            isGameClear = gameScore.isGameClear();
        }

    }

}
