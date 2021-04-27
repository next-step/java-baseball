package baseball.domain;

public class BaseballGame {
    private Hitter hitter;

    public BaseballGame(Hitter hitter) {
        this.hitter = hitter;
    }

    public Referee start(){
        Referee referee = new Referee(this.hitter);

        return null;
    }

}
