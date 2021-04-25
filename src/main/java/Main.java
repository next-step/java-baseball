import computer.RandomBaseballGenerator;
import user.BaseballUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomBaseballGenerator randomBaseballGenerator = new RandomBaseballGenerator();
        BaseballUser baseballUser = new BaseballUser();

        BaseballGame baseballGame = new BaseballGame(sc, randomBaseballGenerator, baseballUser);
        baseballGame.start();
        sc.close();
    }
}
