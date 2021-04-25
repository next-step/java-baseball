import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vo.BaseBallNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumberTest {

    @Test
    @DisplayName("숫자 생성 사이즈 제한 테스트")
    void createBaseBallNumberSizeTest() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        //then
        assertThatThrownBy(() -> new BaseBallNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(String.format("숫자야구게임의 생성 숫자는 %d개만 가능합니다.",
                        BaseBallNumber.BASEBALL_NUMBER_SIZE));
    }

    @Test
    @DisplayName("숫자 생성 중복 테스트")
    void createBaseBallNumberDuplicateTest() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);

        //then
        assertThatThrownBy(() -> new BaseBallNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("숫자야구게임의 생성 숫자는 중복될 수 없습니다.");
    }
}
