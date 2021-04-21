package baseball;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Baseball {

    private static String answer = "";
    private static Random random = new Random();

    public static void main(String[] args) {
        while(true) {
            initGame();

            playGame();

            endGame();
        }
    }


    private static void initGame() {
        answer = "";
        random.setSeed(System.currentTimeMillis());

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while(set.size() != 3) {
            set.add(random.nextInt(9) + 1);
        }

        for (int number : set) {
            answer += number;
        }
    }

    private static void playGame() {

    }

    private static void endGame() {

    }
}
