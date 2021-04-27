package baseball.domain;

public class Referee {

  private final Balls computerBalls;
  private final Balls userBalls;

  public Referee(Balls computerBalls, Balls userBalls) {
    this.computerBalls = computerBalls;
    this.userBalls = userBalls;
  }

  public ScoreBoard judge() {
    ScoreBoard scoreBoard = new ScoreBoard();
    for (int i=0 ; i < computerBalls.size() ; i++) {
      Score score = computerBalls.calculateScore(userBalls, i);
      scoreBoard.recordScore(score);
    }
    return scoreBoard;
  }
}
