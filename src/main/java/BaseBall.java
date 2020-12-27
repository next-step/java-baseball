import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseBall {

    private final List<Integer> answer;
    private final int MAX_SIZE = 3;

    public BaseBall() {
        answer = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            Random generator = new Random();
            int randomNumber = generator.nextInt(10);
            answer.add(randomNumber);
        }
    }

}
