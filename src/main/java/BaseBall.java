import java.util.*;

public class BaseBall {

    private final List<Integer> answer;
    private final int MAX_SIZE = 3;
    private Set<Integer> answerNumberSet;

    public BaseBall() {
        answer = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            Random generator = new Random();
            int randomNumber = generator.nextInt(10);
            answer.add(randomNumber);
        }
    }

    public Respond calculate(List<Integer> userInput) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            strikes = increaseWhenStrike(strikes, answer.get(i), userInput.get(i));
        }

        answerNumberSet = new HashSet<>(answer);
        for (int i = 0; i < MAX_SIZE; i++) {
            balls = increaseWhenBall(balls, userInput.get(i));
        }

        return new Respond(strikes, balls);
    }

    private int increaseWhenStrike(int strikes, int x, int y) {
        if (x == y) return strikes + 1;
        return strikes;
    }

    private int increaseWhenBall(int balls, int x) {
        if (answerNumberSet.contains(x)) {
            answerNumberSet.remove(x);
            return balls + 1;
        }
        return balls;
    }

}
