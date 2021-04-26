import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @DisplayName("judgement test - nothing")
    @Test
    void makeQuestion_judge_nothing() {
        Question question = new Question(Arrays.asList(1, 2, 3));
        JudgeResult judgeResult = question.judge(Arrays.asList(4, 5, 6));

        assertThat(judgeResult.getStrike()).isEqualTo(0);
        assertThat(judgeResult.getBall()).isEqualTo(0);
        assertThat(judgeResult.isNothing()).isTrue();
        assertThat(judgeResult.isSolved()).isFalse();
    }

    @DisplayName("judgement test - 3 balls")
    @Test
    void makeQuestion_judge_3_balls() {
        Question question = new Question(Arrays.asList(1, 2, 3));
        JudgeResult judgeResult = question.judge(Arrays.asList(2, 3, 1));

        assertThat(judgeResult.getStrike()).isEqualTo(0);
        assertThat(judgeResult.getBall()).isEqualTo(3);
        assertThat(judgeResult.isNothing()).isFalse();
        assertThat(judgeResult.isSolved()).isFalse();
    }

    @DisplayName("judgement test - 1 strike, 2 balls")
    @Test
    void makeQuestion_judge_1_strike_2_balls() {
        Question question = new Question(Arrays.asList(1, 2, 3));
        JudgeResult judgeResult = question.judge(Arrays.asList(1, 3, 2));

        assertThat(judgeResult.getStrike()).isEqualTo(1);
        assertThat(judgeResult.getBall()).isEqualTo(2);
        assertThat(judgeResult.isNothing()).isFalse();
        assertThat(judgeResult.isSolved()).isFalse();
    }

    @DisplayName("judgement test - 1 strike, 1 ball")
    @Test
    void makeQuestion_judge_1_strike_1_ball() {
        Question question = new Question(Arrays.asList(1, 2, 3));
        JudgeResult judgeResult = question.judge(Arrays.asList(1, 9, 2));

        assertThat(judgeResult.getStrike()).isEqualTo(1);
        assertThat(judgeResult.getBall()).isEqualTo(1);
        assertThat(judgeResult.isNothing()).isFalse();
        assertThat(judgeResult.isSolved()).isFalse();
    }

    @DisplayName("judgement test - 1 strike")
    @Test
    void makeQuestion_judge_1_strike() {
        Question question = new Question(Arrays.asList(1, 2, 3));
        JudgeResult judgeResult = question.judge(Arrays.asList(1, 8, 9));

        assertThat(judgeResult.getStrike()).isEqualTo(1);
        assertThat(judgeResult.getBall()).isEqualTo(0);
        assertThat(judgeResult.isNothing()).isFalse();
        assertThat(judgeResult.isSolved()).isFalse();
    }

    @DisplayName("judgement test - 1 ball")
    @Test
    void makeQuestion_judge_1_ball() {
        Question question = new Question(Arrays.asList(1, 2, 3));
        JudgeResult judgeResult = question.judge(Arrays.asList(4, 5, 1));

        assertThat(judgeResult.getStrike()).isEqualTo(0);
        assertThat(judgeResult.getBall()).isEqualTo(1);
        assertThat(judgeResult.isNothing()).isFalse();
        assertThat(judgeResult.isSolved()).isFalse();
    }

    @DisplayName("judgement test - 3 strikes")
    @Test
    void makeQuestion_judge_3_strikes() {
        Question question = new Question(Arrays.asList(1, 2, 3));
        JudgeResult judgeResult = question.judge(Arrays.asList(1, 2, 3));

        assertThat(judgeResult.getStrike()).isEqualTo(3);
        assertThat(judgeResult.getBall()).isEqualTo(0);
        assertThat(judgeResult.isNothing()).isFalse();
        assertThat(judgeResult.isSolved()).isTrue();
    }
}