package baseballgame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameCenter gameCenter = new GameCenter(new Scanner(System.in));
        gameCenter.startGame();
    }
}
