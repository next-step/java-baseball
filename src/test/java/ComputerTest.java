import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {


    @RepeatedTest(20)
    @DisplayName("중복 없는 난수 생성 테스트")
    public void generate_number() {
        //given
        Computer computer = new Computer();
        computer.generateNumber();

        //when
        List<String> numbers = computer.getNumbers();

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
        List<String> numbers = computer.getNumbers();
        computer.generateNumber();

        //then
        assertThat(computer.getNumbers()).isNotEqualTo(numbers);
    }

    @Test
    public void check_result_test() {
        //given
        Computer computer = new Computer();
        computer.generateNumber();
        List<String> userNumbers = new ArrayList<>(computer.getNumbers());
        //when
        Collections.reverse(userNumbers);
        computer.checkResult(userNumbers);
        String result = computer.resultMessage();

        //then
        assertThat(result)
                .contains("1스트라이크")
                .contains("2볼");
    }
}