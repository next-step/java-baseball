package baseballgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BaseballGame baseballGame = new BaseballGame(bufferedReader);
        do {
            baseballGame.game();
        } while (!baseballGame.isFinishGame());
        bufferedReader.close();
    }
}
