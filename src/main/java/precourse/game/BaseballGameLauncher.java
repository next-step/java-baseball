package precourse.game;

import precourse.player.Computer;
import precourse.player.User;

public class BaseballGameLauncher {

    private boolean isPowerOn = true;

    public void launch() {
        while (isPowerOn) {
            Computer computer = new Computer();
            User user = new User();
            BaseballGame baseballGame = new BaseballGame();

            UserChoice userChoice = baseballGame.play(computer, user);
            turnSwitchBy(userChoice);
        }
    }

    private void turnSwitchBy(UserChoice choice) {
        if (choice.isStartNewGame()) {
            launch();
        }

        if (choice.isQuitGame()) {
            quit();
        }
    }

    private void quit() {
        isPowerOn = false;
    }
    
}
