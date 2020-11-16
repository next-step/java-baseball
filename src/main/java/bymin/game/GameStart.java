package bymin.game;

import bymin.game.play.GameMaster;

public class GameStart {
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();
        gameMaster.whilePlay();
    }
}
