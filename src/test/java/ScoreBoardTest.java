import domain.Number;
import domain.ScoreBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ScoreBoardTest {

    @ParameterizedTest
    @ValueSource(ints = {234, 234, 362} )
    void intToNumberList(int number) {
        List<Number> numberList = new ScoreBoard().toNumber(number);
        assertThat(numberList.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {123, 234, 362} )
    void 생성(int number) {
        ScoreBoard scoreBoard = new ScoreBoard(number);
        assertThat(scoreBoard.boardSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {223, 333, 366} )
    void 중복입력(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(()->{
          new ScoreBoard(number);
        });
    }
}
