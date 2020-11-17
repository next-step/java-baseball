package baseball;

import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Computer computer;

    public Game() {
        init();
    }

    private void init() {
        this.scanner = new Scanner(System.in);
        this.computer = new Computer();
    }

    public void run() { }
}
