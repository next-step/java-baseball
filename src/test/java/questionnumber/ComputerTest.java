package questionnumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ComputerTest {
    QuestionNumber questionNumber;

    @BeforeEach
    void setUp() {
        questionNumber = new QuestionNumber();
    }

    @Test
    void setQuestionNumber() {
        // when
        List<Integer> changeNumberValue = new ArrayList<>();

        Collections.shuffle(questionNumber.getNumberRange());

        for (int i = 0; i < questionNumber.getNumberCount(); i++) {
            changeNumberValue.add(questionNumber.getNumberRange().get(i));
        }

        questionNumber.changeQuestionNumber(changeNumberValue);

        System.out.println(this.questionNumber.getQuestionNumber());
    }
}
