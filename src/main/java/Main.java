import nextstep.baseball.di.Injection;
import nextstep.baseball.service.BaseballGame;

public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGame = Injection.provideBaseballGame();
        baseballGame.start();
    }
}
