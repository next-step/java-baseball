import baseball.AbnormalInputException;
import baseball.GameModel;
import baseball.OutputProvider;
import com.sun.tools.javac.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameModelTest {

    @Test
    void flushOutput_ShouldPrintInputMessage() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        String actual = model.flushOutput();

        assertThat(actual).isEqualTo(OutputProvider.REQUEST_INPUT);
    }

    @Test
    void flushOutput_ShouldPrintNothing() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.flushOutput();

        model.input("456");

        String actual = model.flushOutput();
        assertThat(actual).startsWith(OutputProvider.RESULT_NOTHING + "\n");
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

            model.input(pair.fst);

            String actual = model.flushOutput();
            assertThat(actual).contains(pair.snd + OutputProvider.RESULT_STRIKE);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"156,1", "423,2", "123,3"}, delimiter = ',')
    void flushOutput_ShouldPrintStrikesUsingParameter(String number, String strike) {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.flushOutput();

        model.input(number);

        String actual = model.flushOutput();
        assertThat(actual).contains(strike + OutputProvider.RESULT_STRIKE);
    }


    @ParameterizedTest
    @CsvSource(value = {"451,1", "314,2", "312,3"}, delimiter = ',')
    void flushOutput_ShouldPrintBalls(String number, String ball) {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.flushOutput();

        model.input(number);

        String actual = model.flushOutput();
        assertThat(actual).startsWith(ball + OutputProvider.RESULT_BALL);
    }

    @Test
    void isComplete_ShouldFalseWhenStartGame() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        boolean actual = model.isComplete();

        assertThat(actual).isFalse();
    }

    @Test
    void flushOutput_ShouldPrintComplete() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.flushOutput();

        model.input("123");

        String actual = model.flushOutput();
        assertThat(actual).contains(OutputProvider.RESULT_COMPLETE);
    }

    @Test
    void flushOutput_ShouldPrintInputWhenStartAgain() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));

        model.input("123");
        model.flushOutput();
        model.input("1");

        String actual = model.flushOutput();
        assertThat(actual).isEqualTo(OutputProvider.REQUEST_INPUT);
    }

    @Test
    void generate_ShouldCallGenerateWhenStartAgain() {
        NumberGeneratorStub spy = new NumberGeneratorStub("123");
        GameModel model = new GameModel(spy);

        model.input("123");
        model.input("1");

        int actual = spy.getGenerateCallCount();

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void isComplete_ShouldCompleteWhenStop() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));

        model.input("123");
        model.input("2");

        boolean actual = model.isComplete();

        assertThat(actual).isTrue();
    }

    @Test
    void input_ShouldThrowWhenInputWrongGuess() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));

        Assertions.assertThrows(AbnormalInputException.class, () -> {
            model.input("1");
        });
    }

    @Test
    void input_ShouldThrowWhenInputWrongModeInPending() {
        GameModel model = new GameModel(new NumberGeneratorStub("123"));
        model.input("123");

        Assertions.assertThrows(AbnormalInputException.class, () -> {
            model.input("123");
        });
    }


}
