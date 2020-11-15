import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.initNumbers();
    }

    @Test
    @DisplayName("baseNumber 목록에 남아있는 숫자 중 랜덤한 위치의 index 가져오기")
    void getRandomIndex() {
        int index = computer.getRandomIndex();
        assertThat(index < computer.getBaseNumbers().size()).isTrue();
    }

    @Test
    @DisplayName("baseNumber 목록에서 index 위치에 있는 숫자 선택 & baseNumber 목록에서 삭제")
    void getNumberFromBase() {
        int expect = computer.getBaseNumbers().get(3);
        int number = computer.getNumberFromBase(3);

        assertThat(number).isEqualTo(expect);
        assertThat(computer.getBaseNumbers().contains(number)).isFalse();
    }

}