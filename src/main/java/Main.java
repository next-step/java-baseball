import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseBallGame bbg = new BaseBallGame();
        do {
            bbg.gamePlay();
        } while (bbg.againGame());

        return;
    }
}
