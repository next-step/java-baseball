import java.util.HashSet;
import java.util.Random;

public class GameHost {
    private Integer[] threeNumGeneratedByComputer;

    private void generateRandThreeNum() {
        threeNumGeneratedByComputer = new Integer[3];
        HashSet<Integer> randNumDeduplicated = new HashSet<>();
        Random randInstance = new Random();

        while (randNumDeduplicated.size() < 3) {
            randNumDeduplicated.add(randInstance.nextInt(9) + 1);
        }
        randNumDeduplicated.toArray(threeNumGeneratedByComputer);
    }

    public void playGame() {

    }

    public static void main(String[] args) {
        GameHost newGame = new GameHost();
        newGame.playGame();
    }
}
