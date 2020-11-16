package baseball;

public class Baseball {
  private final Player player;
  private final Opponent opponent;

  public Baseball() {
    this.player = new Player();
    this.opponent = new Opponent();
  }

  public void start() {
    opponent.selectValue();


  }
}
