package baseball.game.ground;

import baseball.game.gameball.GameBall;
import baseball.game.hitter.Hitter;
import baseball.game.pitcher.Pitcher;
import baseball.game.referee.Referee;
import baseball.game.scoreBoard.ScoreBoard;
import baseball.ui.UiSystem;

public class Ground {

    private boolean playing = false;
    private final UiSystem uiSystem;

    private Pitcher pitcher;
    private Hitter hitter;


    public Ground(UiSystem uiSystem) {
        this.uiSystem = uiSystem;
    }

    /**
     * 데이터 초기화
     */
    private void init() {
        this.pitcher = new Pitcher(uiSystem);
        this.hitter = new Hitter(GameBall.create());
        this.playing = true;
    }

    public void update(Referee referee) {

        init();
        while (this.playing) {

            String pitcherNum = this.pitcher.throwing();
            String hitterNum = this.hitter.swing();

            ScoreBoard scoreBoard = referee.judgement(pitcherNum, hitterNum);
            scoreBoard.display(uiSystem);

            this.playing = referee.nextPlay();
        }

    }
}
