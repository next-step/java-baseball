package questionnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionNumber {
    private List<Integer> numberRange = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    private int numberCount = 3;

    private List<Integer> questionNumber;

    public QuestionNumber() {
        this.questionNumber = new ArrayList<>();
    }

    public void changeQuestionNumber(List<Integer> thoughtNumber) {
        this.questionNumber = thoughtNumber;
    }

    public List<Integer> getQuestionNumber() {
        return questionNumber;
    }

    public List<Integer> getNumberRange() {
        return numberRange;
    }

    public int getNumberCount() {
        return numberCount;
    }
}
