package precourse.baseball;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballGeneratorTest {

    @DisplayName("1 ~ 9 사이의 임의의 숫자로 중복되지 않는 야구공을 생성한다.")
    @Test
    void randomBaseballs() throws NoSuchFieldException, IllegalAccessException {
        precourse.baseball.BaseballGenerator generator = new precourse.baseball.BaseballGenerator();
        precourse.baseball.Baseballs baseballs = generator.createRandomBaseballs();

        Field field = baseballs.getClass().getDeclaredField("basket");
        field.setAccessible(true);
        List<precourse.baseball.Baseball> basket = (List<precourse.baseball.Baseball>) field.get(baseballs);
        Set<precourse.baseball.Baseball> nonDuplicateBasket = new HashSet<>(basket);

        assertThat(nonDuplicateBasket.size()).isEqualTo(3);
    }
    
    @DisplayName("전달한 숫자 문자열로 중복되지 않는 야구공을 생성한다.")
    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"123", "456", "789"})
    void baseballs(String answer) throws NoSuchFieldException, IllegalAccessException {
        precourse.baseball.BaseballGenerator generator = new precourse.baseball.BaseballGenerator();
        precourse.baseball.Baseballs baseballs = generator.createBaseballs(answer);

        Field field = baseballs.getClass().getDeclaredField("basket");
        field.setAccessible(true);
        List<precourse.baseball.Baseball> basket = (List<precourse.baseball.Baseball>) field.get(baseballs);
        Set<precourse.baseball.Baseball> nonDuplicateBasket = new HashSet<>(basket);

        assertThat(nonDuplicateBasket.size()).isEqualTo(3);
    }

    @DisplayName("유효하지 않은 문자열을 전달할 경우 예외가 발생한다.")
    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"111", "012", "!@#", "abc"})
    void invalidBaseballs(String answer) {
        precourse.baseball.BaseballGenerator generator = new precourse.baseball.BaseballGenerator();

        assertThatIllegalArgumentException().isThrownBy(() -> generator.createBaseballs(answer));
    }

}