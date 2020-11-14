package view;

import exception.*;

import static util.Printer.*;

public class BaseBallGameStarter {
    private BaseBallGame baseBallGame;
    public BaseBallGameStarter() {
        this.baseBallGame = new BaseBallGame();
    }

    public void start() {
        try {
            baseBallGame.play();
        } catch (OutOfRangeBBNException | OutOfSizeBBNException | DuplicatedBBNException e) {
            println(e.getMessage());
            baseBallGame.round();
        } catch (InvalidGameCommandException e) {
            println(e.getMessage());
            baseBallGame.chooseCommand();
        }
    }
}
