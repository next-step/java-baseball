package launcher;

import game.Game;

public class GameLauncher {
    Game game;
    public GameLauncher(Game game){
        this.game = game;
    }
    public void launch(){
        game.execute();
    }
}
