import Model.GameState;

import java.util.Scanner;

public class GameHelper {
    public static void main(String[] args) {
        Game game = new Game();
        GameState gameState;
        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            game.playGame();
            gameState = game.askToContinue();
        } while (gameState != GameState.END);
    }
}

