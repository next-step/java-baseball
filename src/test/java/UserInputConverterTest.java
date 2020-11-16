import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 입력 숫자 클래스 테스트")
class UserInputConverterTest {

    @Test
    @DisplayName("사용자가 입력한 숫자를 list로 변환하는 테스트")
    void convertBalls() {
        List<Integer> expected = Arrays.asList(1,2,3);

        UserInputConverter userInputConverter = new UserInputConverter("123");
        List<Integer> actual = userInputConverter.convertBallsItem();

        assertThat(actual).isEqualTo(expected);

    }
}