import game.GameRunner;
import game.baseball.application.BaseballGame;
import game.baseball.domain.rule.NormalModeRule;

public class MainApplication {
    public static void main(String[] args) {
        GameRunner.run(new BaseballGame(new NormalModeRule()));
    }
}
