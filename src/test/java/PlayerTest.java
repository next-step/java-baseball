import domain.*;
import domain.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {

    @ParameterizedTest
    @ValueSource(ints = {234, 234, 362} )
    void intToNumberList(int number) {
        List<Number> numberList = new Player().toNumber(number);
        assertThat(numberList.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {123, 234, 362} )
    void 생성(int number) {
        Player player = new Player(number);
        assertThat(player.boardSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {223, 333, 366} )
    void 중복입력(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(()->{
          new Player(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1234, 9621} )
    void 유효하지_않는_값_입력(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    new Player(number);
                });
    }
    @ParameterizedTest
    @CsvSource(value = {"123,123","234,234","823,823"})
    void 스트라이크_3(int intComputer, int intUser){
        Player computer = new Player(intComputer);
        Player user = new Player(intUser);
        Result result = new Result();
        computer.match(user,result);
        assertThat(new Count(3)).isEqualTo(result.stateCount(State.STRIKE));
    }

    @ParameterizedTest
    @CsvSource(value = {"123,312","423,234","382,823"})
    void 볼_3(int intComputer, int intUser){
        Player computer = new Player(intComputer);
        Player user = new Player(intUser);
        Result result = new Result();
        computer.match(user,result);
        assertThat(new Count(3)).isEqualTo(result.stateCount(State.BOLL));
    }

    @ParameterizedTest
    @CsvSource(value = {"123,456","789,234","457,823"})
    void 낫싱_3(int intComputer, int intUser){
        Player computer = new Player(intComputer);
        Player user = new Player(intUser);
        Result result = new Result();
        computer.match(user,result);
        assertThat(new Count(3)).isEqualTo(result.stateCount(State.NOTHING));
    }
}
