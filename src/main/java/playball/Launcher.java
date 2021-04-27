package playball;

import playball.service.PlayBallGame;

public class Launcher {

    public static void main(String[] args) {
        PlayBallGame playBallGame = new PlayBallGame();
        playBallGame.runPlayBallGame();
    }
}
