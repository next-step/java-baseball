package precourse.baseball.manager;

import precourse.baseball.hitter.Hitter;
import precourse.baseball.pitcher.Pitcher;
import precourse.baseball.printer.GamePrinter;
import precourse.baseball.printer.PrintMessage;
import precourse.baseball.referee.Point;
import precourse.baseball.referee.Referee;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static precourse.baseball.printer.PrintMessage.ENTER_NUMBER;
import static precourse.baseball.printer.PrintMessage.GAME_RESTART_OR_NOT;
import static precourse.baseball.printer.PrintMessage.GAME_STOP;

public class GameManager {

  private final Pitcher pitcher;
  private final Hitter hitter;
  private final Referee referee;
  private final GamePrinter printer;

  public GameManager(Pitcher pitcher, Hitter hitter, Referee referee, GamePrinter printer) {
    this.pitcher = pitcher;
    this.hitter = hitter;
    this.referee = referee;
    this.printer = printer;
  }

  public void start() {
    try {
      playWith(pitcher.pitch());
    } catch (Exception e) {
      return;
    }

    printer.print(GAME_STOP);
    if (isRestart()) {
      start();
    }
  }

  public boolean isRestart() {
    printer.print(GAME_RESTART_OR_NOT);
    return new Scanner(System.in).nextInt() == 1;
  }

  private void playWith(Set<Integer> answer) {
    printer.print(ENTER_NUMBER);
    Map<PrintMessage, Point> result = referee.judge(hitter.hit(), answer);
    printer.print(result);

    if (isNotStrikeThreeTimes()) {
      playWith(answer);
    }
  }

  private Boolean isNotStrikeThreeTimes() {
    return !referee.isStrikeThreeTimes();
  }
}
