import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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

    private ArrayList<Integer> convertSetToShuffledList(HashSet<Integer> set) {
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.shuffle(list);

        return list;
    }

    private int getRandomAnswerNumber() {
        HashSet<Integer> set = new HashSet<>();

        while(set.size() < answerLength) {
            set.add(getRandomSingleDigitInt());
        }

        StringBuilder tempString = new StringBuilder("");
        ArrayList<Integer> list = convertSetToShuffledList(set);

        for(int num : list) {
            tempString.append(num);
        }

        return Integer.parseInt(tempString.toString());
    }
}
