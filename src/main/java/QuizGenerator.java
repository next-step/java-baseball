import java.util.HashSet;
import java.util.Iterator;

public class QuizGenerator {

    private final int MIN = 1;
    private final int MAX = 9;
    private int answerLength;

    QuizGenerator(int ANSWER_LENGTH) {
        answerLength = ANSWER_LENGTH;
    }

    public int generate() {
        return getRandomAnswerNumber();
    }

    private int getRandomSingleDigitInt() {
        return (int)(Math.random() * (MAX - MIN + 1) + MIN);
    }

    private int getRandomAnswerNumber() {
        HashSet<Integer> set = new HashSet<Integer>();

        while(set.size() < answerLength) {
            set.add(getRandomSingleDigitInt());
        }

        StringBuilder tempString = new StringBuilder("");

        for(int num : set) {
            tempString.append(num);
        }

        return Integer.parseInt(tempString.toString());
    }
}
