package precourse.baseball;

import precourse.baseball.hitter.Hitter;
import precourse.baseball.manager.GameManager;
import precourse.baseball.pitcher.Pitcher;
import precourse.baseball.printer.GamePrinter;
import precourse.baseball.printer.Nothing;
import precourse.baseball.printer.OnlyBall;
import precourse.baseball.printer.OnlyStrike;
import precourse.baseball.printer.StrikeAndBall;
import precourse.baseball.referee.Ball;
import precourse.baseball.referee.Referee;
import precourse.baseball.referee.Strike;

import java.util.Arrays;
import java.util.Random;

public class GameClient {

  public static void main(String[] args) {
    GameManager manager = new GameManager(
        new Pitcher(new Random()),
        new Hitter(),
        new Referee(new Strike(), new Ball()),
        new GamePrinter(Arrays.asList(new StrikeAndBall(), new OnlyStrike(), new OnlyBall(), new Nothing()))
    );

    manager.start();
  }
}
