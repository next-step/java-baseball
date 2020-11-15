import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {


    @RepeatedTest(20)
    @DisplayName("중복 없는 난수 생성 테스트")
    public void generate_number() {
        //given
        Computer computer = new Computer();
        computer.generateNumber();

        //when
        List<Integer> numbers = computer.getNumbers();

        //then
        assertThat(numbers)
                .hasSize(3)
                .doesNotHaveDuplicates();
    }

    @RepeatedTest(5)
    @DisplayName("난수 초기화 테스트")
    public void reset_numbers() {
        //given
        Computer computer = new Computer();
        computer.generateNumber();

        //when
        List<Integer> numbers = computer.getNumbers();
        computer.generateNumber();

        //then
        assertThat(computer.getNumbers()).isNotEqualTo(numbers);
    }

}