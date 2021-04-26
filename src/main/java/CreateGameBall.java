import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateGameBall {

    private final Random random = new Random();

    public List<Integer> getBall() {
        List numberList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            createBall(numberList);
        }
        return numberList;
    }

    private List<Integer> createBall(List<Integer> numberList) {
        int gameBall = random.nextInt(9) + 1;
        while (numberList.contains(gameBall)) {
            gameBall = random.nextInt(9) + 1;
        }
        numberList.add(gameBall);
        return numberList;
    }
}
