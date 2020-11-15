package baseballgame.ui.input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final Scanner SCAN = new Scanner(System.in);

    @Override
    public String userScore() {
        return SCAN.nextLine();
    }

    @Override
    public String whetherWantToRestartGame() {
        return SCAN.nextLine();
    }
}
