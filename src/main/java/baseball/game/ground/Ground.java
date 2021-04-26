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
    private final Pitcher pitcher;
    private Hitter hitter;


    public Ground(UiSystem uiSystem) {
        this.uiSystem = uiSystem;
        this.pitcher = new Pitcher(uiSystem);
        this.hitter = new Hitter(GameBall.create());
    }


    private void init() {
        this.hitter = new Hitter(GameBall.create());
        this.playing = true;
    }

    // 플레이시 hitter 데이터가 두번 생성 되지만 trade off
    // 재시작 및 테스트에 대한 무결성 & 유연함이 보장됨
    // 성능이 느려진다면 생각할 부분, 이런 코드에서는 아니다
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
