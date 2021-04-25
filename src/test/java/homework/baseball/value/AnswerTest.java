package homework.baseball.value;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    private Answer answer;
    private List<String> numbers;

    @BeforeEach
    public void beforeEach() {
        this.answer = new Answer("437");
        this.numbers = new ArrayList<>();
        for (int first = 1; first < 10; first++) {
            for (int second = 1; second < 10; second++) {
                if (first == second) {
                    continue;
                }
                for (int third = 1; third < 10; third++) {
                    if (first == third || second == third) {
                        continue;
                    }
                    numbers.add(new StringBuffer().append(first).append(second).append(third).toString());
                }
            }
        }
    }

    @Test
    public void compareWithUserAnswerTest() {
        List<Answer> answers = new ArrayList<>();
        for (String number : numbers) {
            Answer userAnswer = new Answer(number);
            if (answer.compareWithUserAnswer(userAnswer)) {
                answers.add(userAnswer);
            }
        }
        assertThat(answers.size()).isEqualTo(1);
    }

    @Test
    public void ballCoutTest() {
        int totalCount = this.numbers.size();
        int oneBallCount = 0;
        int twoBallCount = 0;
        int threeBallCount = 0;
        int noBallCount = 0;
        for (String number : numbers) {
            Answer temp = new Answer(number);
            int count = answer.getBallCount(temp);
            if (count == 0) {
                noBallCount++;
            } else if (count == 1) {
                oneBallCount++;
            } else if (count == 2) {
                twoBallCount++;
            } else if (count == 3) {
                threeBallCount++;
            }
        }
        assertThat(oneBallCount).isEqualTo(216);
        assertThat(twoBallCount).isEqualTo(57);
        assertThat(threeBallCount).isEqualTo(2);
        assertThat(totalCount).isEqualTo(oneBallCount + twoBallCount + threeBallCount + noBallCount);
    }

    @Test
    public void strikeCoutTest() {
        int totalCount = this.numbers.size();
        int oneStrikeCount = 0;
        int twoStrikeCount = 0;
        int threeStrikeCount = 0;
        int noStrikeCount = 0;
        for (String number : numbers) {
            Answer temp = new Answer(number);
            int count = answer.getStrikeCount(temp);
            if (count == 0) {
                noStrikeCount++;
            } else if (count == 1) {
                oneStrikeCount++;
            } else if (count == 2) {
                twoStrikeCount++;
            } else if (count == 3) {
                threeStrikeCount++;
            }
        }
        assertThat(oneStrikeCount).isEqualTo(129);
        assertThat(twoStrikeCount).isEqualTo(18);
        assertThat(threeStrikeCount).isEqualTo(1);
        assertThat(totalCount).isEqualTo(oneStrikeCount + twoStrikeCount + threeStrikeCount + noStrikeCount);
    }
}
