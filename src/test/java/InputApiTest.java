import input.InputApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import referee.BaseballCall;

import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class InputApiTest {
    @ParameterizedTest
    @CsvSource({"1,false", "12,false", "124,true", "111,false", "1245,false", "adb,false", "a23,false", "'',false"})
    public void gameInputValidTest(String input, boolean expected){
        assertThat(InputApi.gameInputValid(input)).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({"123,start,false","abc,start,false", "1,start,true", "2,start,true"})
    public void newGameValidTest(String input, String condition, boolean expected){
        assertThat(InputApi.checkValidIn(input,condition)).isEqualTo(expected);
    }
}
