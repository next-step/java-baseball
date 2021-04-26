import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionTest {

    @DisplayName("Question have 3 numbers and does")
    @RepeatedTest(100)
    void makeQuestion_have_3_numbers() {
        Question question = new Question();

        List<Integer> questions = question.getQuestions();

        assertThat(questions)
                .as("check that question size is 3")
                .hasSize(3)
        ;
    }

    @DisplayName("each number of questions range is 1 to 9")
    @RepeatedTest(100)
    void makeQuestion_each_number_range_is_1_to_9() {
        Question question = new Question();

        List<Integer> questions = question.getQuestions();

        for (Integer number : questions) {
            assertThat(number)
                    .as("check that number's range is 1 to 9")
                    .isLessThan(10)
                    .isNotEqualTo(0)
            ;
        }
    }
}