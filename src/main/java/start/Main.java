package start;

import start.game.BaseBall;
import start.game.BaseBallImpl;
import start.game.BaseBallUI;

public class Main {

    public static void main(String[] args) {
        BaseBallUI ui = new BaseBallUI();
        BaseBall game = new BaseBallImpl(ui);
        game.start();
    }

}
