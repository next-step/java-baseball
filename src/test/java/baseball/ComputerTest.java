package baseball;

import baseball.entity.Computer;
import baseball.model.CompareResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.entity.Computer.INVALID_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ComputerTest {
    private Computer computer;
    private String initSelectedNumber;

    @BeforeEach
    void setup(){
        initSelectedNumber = "257";
        computer = new Computer(initSelectedNumber);
    }

    @Test
    @DisplayName("컴퓨터 생성")
    public void createComputer(){
        assertThat(computer.equals(new Computer(initSelectedNumber))).isTrue();
    }

    @Test
    @DisplayName("잘못 된 자리 수 선택")
    public void invalidLengthNumberSelected(){
        String selectNumber = "1234";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Computer(selectNumber))
                .withMessageMatching(INVALID_NUMBER_MESSAGE);
    }

    @Test
    @DisplayName("중복 된 수 선택")
    public void duplicateNumberSelected(){
        String selectNumber = "223";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Computer(selectNumber))
                .withMessageMatching(INVALID_NUMBER_MESSAGE);
    }

    @Test
    @DisplayName("숫자 비교")
    public void compareNumber(){

        String selectNumber = "235";

        CompareResult compareResult = computer.compareNumber(selectNumber);

        assertThat(compareResult.strikeCount() == 1).isTrue();
        assertThat(compareResult.ballCount() == 1).isTrue();
    }
}
