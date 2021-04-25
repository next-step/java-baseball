import game.baseball.BaseballGame;
import launcher.GameLauncher;

public class Main {
    public static void main(String[] args){
        GameLauncher gameLauncher = new GameLauncher(new BaseballGame());
        gameLauncher.launch();
    }
}
