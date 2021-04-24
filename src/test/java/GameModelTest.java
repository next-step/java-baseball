import baseball.GameModel;
import com.sun.tools.javac.util.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameModelTest {

    @Test
    void flushOutput_ShouldPrintInputMessage() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        String actual = model.flushOutput();

        assertThat(actual).isEqualTo(GameModel.REQUEST_INPUT);
    }

    @Test
    void flushOutput_ShouldPrintNothing() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.flushOutput();

        model.guess("456");

        String actual = model.flushOutput();
        assertThat(actual).startsWith(GameModel.RESULT_NOTHING);
    }

    @Test
    void flushOutput_ShouldPrintStrikes() {
        List<Pair<String, String>> list = new ArrayList<>();
        list.add(new Pair<>("156", "1"));
        list.add(new Pair<>("126", "2"));
        list.add(new Pair<>("123", "3"));

        for (Pair<String, String> pair : list) {
            GameModel model = new GameModel(new NumberGeneratorStub("123"));
            model.flushOutput();

            model.guess(pair.fst);

            String actual = model.flushOutput();
            assertThat(actual).contains(pair.snd + GameModel.RESULT_STRIKE);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"156,1", "423,2", "123,3"})
    void flushOutput_ShouldPrintStrikesUsingParameter(String param) {
        String[] numberAndStrike = param.split(",");
        String number = numberAndStrike[0];
        String strike = numberAndStrike[1];
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.flushOutput();

        model.guess(number);

        String actual = model.flushOutput();
        assertThat(actual).contains(strike + GameModel.RESULT_STRIKE);
    }


    @ParameterizedTest
    @ValueSource(strings = {"451,1", "314,2", "312,3"})
    void flushOutput_ShouldPrintBalls(String param) {
        String[] numberAndBall = param.split(",");
        String number = numberAndBall[0];
        String ball = numberAndBall[1];
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.flushOutput();

        model.guess(number);

        String actual = model.flushOutput();
        assertThat(actual).startsWith(ball + GameModel.RESULT_BALL);
    }
}
