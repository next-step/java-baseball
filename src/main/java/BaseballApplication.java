import domain.Game;

import java.util.Scanner;

public class BaseballApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (!game.isOver()) {
            game.play(scanner);
        }

        scanner.close();
    }
}
