package baseballgame;

import baseballgame.game.GameNumber;
import baseballgame.view.InputConverter;
import baseballgame.view.InputScanner;

public class Application {

    public static void main(String[] args) {
        try {
            play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void play() {
        while (true) {
            final String input = InputScanner.read();
            final GameNumber inputGameNumber = InputConverter.convertToGameNumber(input);
            System.out.println(inputGameNumber.toString());
        }
    }

}
