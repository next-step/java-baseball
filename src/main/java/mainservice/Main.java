package mainservice;

import interfaces.Game;
import service.GameImplement;

public class Main {
    public static void main(String[] args) {

        Game game = new GameImplement();
        //start Game
        game.play();






    }
}
