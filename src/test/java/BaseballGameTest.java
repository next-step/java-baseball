import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballGameTest {
    private BaseballGame game;

    @BeforeEach
    void setUp(){
        game = new BaseballGame();
    }

    @Test
    @DisplayName("컴퓨터의 수에 해당 숫자가 포함되어 있는지 확인")
    public void test1(){
        assertThat(game.getNum()).contains("2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 Exception 발생")
    public void test2(){
        assertThatThrownBy(() -> {
            game.getNum().charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, length:3");
    }

    @Test
    @DisplayName("컴퓨터의 수가 3자리인지 비교")
    public void test3(){
        assertThat(game.getNum().length()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "7", "9"})
    @DisplayName("컴퓨터의 수에 3, 7, 9가 있는지 확인")
    public void test4(String number){
        assertThat(game.getNum().contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:True", "5:False", "7:True"}, delimiter = ':')
    @DisplayName("컴퓨터의 수에 3, 7, 9가 있는지 확인")
    public void test5(String input, Boolean expected){
        Boolean actualValue = game.getNum().contains(input);
        assertEquals(expected, actualValue);
    }
}
