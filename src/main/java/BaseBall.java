import java.util.*;

public class BaseBall {

    private final List<Integer> answer;
    private final int MAX_SIZE = 3;
    private List<Integer> answerNumber;

    public BaseBall() {
        Random generator = new Random();
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < MAX_SIZE) {
            numberSet.add(generator.nextInt(9) + 1);
        }
        answer = new ArrayList<>(numberSet);
    }

    public Respond calculate(List<Integer> userInput) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            strikes = increaseWhenStrike(strikes, answer.get(i), userInput.get(i));
        }

        answerNumber = new LinkedList<>(answer);
        for (int i = 0; i < MAX_SIZE; i++) {
            balls = increaseWhenBall(balls, userInput.get(i));
        }

        return new Respond(strikes, balls - strikes);
    }

    private int increaseWhenStrike(int strikes, int x, int y) {
        if (x == y) return strikes + 1;
        return strikes;
    }

    private int increaseWhenBall(int balls, int x) {
        if (answerNumber.contains(x)) {
            answerNumber.remove(answerNumber.indexOf(x));
            return balls + 1;
        }
        return balls;
    }

}
