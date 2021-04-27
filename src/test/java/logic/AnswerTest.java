package logic;

import org.junit.jupiter.api.Test;
import process.GameResult;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {


    @Test
    void 값이_동일하면_STRIKE에만_표시한다() {
        // given
        Answer answer = new Answer();
        List<Integer> question = answer.getAnswer().stream().map(i -> i).collect(Collectors.toList());

        // when
        GameResult gameResult = answer.calculateResult(question);

        // then
        assertEquals(gameResult.isGameEnd(), true);

    }

    @Test
    void 숫자_문자열이_들어오면_정상적으로_answer_format으로_변경한다() {
        // given

        Answer answer = new Answer();
        answer.generateAnswer();

        //when
        StringBuilder answerString = new StringBuilder();
        for (int v : answer.getAnswer()) {
            answerString.append(v);
        }
        List<Integer> formattedAnswer = Answer.convertStringToAnswerFormat(answerString.toString());

        // then
        assertEquals(formattedAnswer, answer.getAnswer());
    }
}