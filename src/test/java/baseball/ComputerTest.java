package baseball;

import baseball.entity.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ComputerTest {

    @Test
    @DisplayName("컴퓨터 생성")
    public void createComputer(){
        String selectNumber = "257";

        Computer computer = new Computer(selectNumber);

        assertThat(computer.equals(new Computer(selectNumber))).isTrue();
    }

    @Test
    @DisplayName("잘못 된 자리 수 선택")
    public void invalidLengthNumberSelected(){
        String selectNumber = "1234";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Computer(selectNumber))
                .withMessageMatching("서로 다른 임의의 수 3개만 선택 가능 합니다.");
    }

    @Test
    @DisplayName("중복 된 수 선택")
    public void duplicateNumberSelected(){
        String selectNumber = "223";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Computer(selectNumber))
                .withMessageMatching("서로 다른 임의의 수 3개만 선택 가능 합니다.");
    }
}
