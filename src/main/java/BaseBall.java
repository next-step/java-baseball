import java.util.*;

public class BaseBall {

    private List<Integer> answer;
    private final int MAX_SIZE = 3;
    private List<Integer> tempAnswer;

    public BaseBall() {
        Random generator = new Random();
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < MAX_SIZE) {
            numberSet.add(generator.nextInt(9) + 1);
        }
        answer = new ArrayList<>(numberSet);
    }

    public void setAnswer(int num1, int num2, int num3) {
        answer = new ArrayList<>(Arrays.asList(num1, num2, num3));
    }

    public Respond calculate(List<Integer> userInput) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            strikes = increaseWhenStrike(strikes, answer.get(i), userInput.get(i));
        }
        tempAnswer = new LinkedList<>(answer);
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
        if (tempAnswer.contains(x)) {
            tempAnswer.remove(tempAnswer.indexOf(x));
            return balls + 1;
        }
        return balls;
    }

}
