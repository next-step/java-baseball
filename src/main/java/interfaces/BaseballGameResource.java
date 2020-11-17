package interfaces;

import application.BaseballGameService;
import application.BaseballGameUserService;

public class BaseballGameResource {

  BaseballGameService baseballGameService;
  BaseballGameUserService baseballGameUserService;

  public BaseballGameResource() {
    baseballGameService = new BaseballGameService();
    baseballGameUserService = new BaseballGameUserService();
  }

  public boolean isGameStatus() {
    return baseballGameUserService.isGameStart();
  }


  public void play() {
    baseballGameService.playGame();
  }

}
