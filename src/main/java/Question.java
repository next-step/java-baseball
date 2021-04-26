import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {

    private List<Integer> question;

    public Question() {
        makeQuestion();
    }

    public List<Integer> getQuestions() {
        return question;
    }

    private void makeQuestion() {
        Random random = new Random();

        question = new ArrayList<>(3);
        question.add(getRandomOneToNine(random));
        question.add(getRandomOneToNine(random));
        question.add(getRandomOneToNine(random));
    }

    private int getRandomOneToNine(Random random) {
        return random.nextInt(9) + 1;
    }
}
