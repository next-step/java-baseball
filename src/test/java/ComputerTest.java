import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

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
        List<Integer> numbers = computer.getNumbers();

        //then
        assertThat(numbers)
                .hasSize(3)
                .doesNotHaveDuplicates();
    }

}