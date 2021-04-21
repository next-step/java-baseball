import domain.enums.State;

import java.util.Scanner;

public class BaseballGame {
    BaseballGame() {
    }

    public void play() {
        final Scanner scanner = new Scanner(System.in);
        boolean isContinue = false;

        do {
            isContinue = start(scanner);
        } while(isContinue);
    }

    public boolean start(Scanner scanner) {
        boolean isSolved = false;

        do {
            isSolved = true;
            System.out.println("solved");
        } while (!isSolved);

        return askContinueGame();
    }

    public boolean askContinueGame() {
        return false;
    }
}
