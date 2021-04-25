package baseball;


import baseball.configures.AppConfig;
import baseball.models.BaseBallNumGame;

public class Program {
    public static void main(String[] args) {
        AppConfig appconfig = new AppConfig();
        BaseBallNumGame baseBallNumGame = appconfig.baseBallNumGame();

        baseBallNumGame.play();

    }
}
