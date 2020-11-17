package application;

import utils.BaseballValidation;
import domain.BaseballCountVo;

public class BaseballGameService {

  BaseballGameUserService baseballGameUserService = new BaseballGameUserService();

  public void playGame() {
    boolean gameStatus = true;
    String computerNumbers = GenerateRandomNumber.generateRandomNumber();
    do {
      String player = baseballGameUserService.playerInputValue();
      BaseballCountVo result = isResult(computerNumbers, player);
      gameStatus = baseballGameUserService.printBallStatus(result);

    } while (!gameStatus);
  }

  public BaseballCountVo isResult(String computer, String player) {

    int ballCount = 0;
    int strikeCount = 0;
    String[] playerInput = stringToStringArray(player);

    for (int i = 0; i < computer.length(); i++) {
      int findIndex = computer.indexOf(playerInput[i]);
      BaseballCountVo result = getBaseballCount(findIndex, i);
      ballCount += result.getBall();
      strikeCount += result.getStrike();
    }

    return new BaseballCountVo(strikeCount, ballCount);
  }

  public BaseballCountVo getBaseballCount(int index, int loop) {
    int ball = 0;
    int strike = 0;

    if (BaseballValidation.isNothing(index)) {
      return new BaseballCountVo(0, 0);
    }

    strike += BaseballValidation.isStrike(loop, index);
    ball += BaseballValidation.isBall(loop, index);

    return new BaseballCountVo(strike, ball);
  }

  public String[] stringToStringArray(String value) {
    return value.split("");
  }
}
