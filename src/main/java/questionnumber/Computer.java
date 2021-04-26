package questionnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer implements QuestionInterface {
    QuestionNumber questionNumber;

    public Computer(QuestionNumber questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public QuestionNumber setQuestionNumber() {
        List<Integer> changeNumberValue = new ArrayList<>();

        Collections.shuffle(questionNumber.getNumberRange());

        for (int i = 0; i < questionNumber.getNumberCount(); i++) {
            changeNumberValue.add(questionNumber.getNumberRange().get(i));
        }

        questionNumber.changeQuestionNumber(changeNumberValue);

        return questionNumber;
    }
}
