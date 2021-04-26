package baseballgame.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumberTest {

    @DisplayName("유효한 범위의 정답을 생성하는지 확인")
    @Test
    void generateTest() {
        //given
        BaseballNumber generator = new AnswerNumber();
        List<String> range = Arrays.asList("1","2","3","4","5","6","7","8","9");

        for (int i = 0; i < 10; i++) {
            //when
            List<String> numbers = generator.getNumber();

            //then
            assertThat(numbers.get(0)).isIn(range);
            assertThat(numbers.get(1)).isIn(range);
            assertThat(numbers.get(2)).isIn(range);
            assertThat(numbers).doesNotHaveDuplicates();
        }
    }

}