import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import org.assertj.core.util.Lists;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    private final Computer computer = new Computer();

    @BeforeEach
    void setUp() {
        computer.initializeNewNumbers();
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 3자리 수 이어야 한다.")
    void isThreeDigitNumberTest() {
        // then
        assertThat(computer.getNumbers().size()).isEqualTo(Computer.NUMBERS_LENGTH);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 자연수로 이루어져야 한다.")
    void isConsistOfNaturalNumberTest() {
        // then
        for (Integer number : computer.getNumbers()) {
            assertThat(number).isBetween(Computer.MIN_NUMBER, Computer.MAX_NUMBER);
        }
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 서로 다른 숫자로 이루어져야 한다.")
    void isConsistOfUniqueNumberTest() {
        // when (computer가 생성한 숫자는 현재 HashSet 이지만, 나중에 바뀔 것을 대비하여 ArrayList로 변환 후 HashSet과 중복 검사 수행)
        ArrayList<Integer> numberList = Lists.newArrayList(computer.getNumbers());
        HashSet<Integer> numberSet = new HashSet<>();

        for (Integer number : numberList) {
            numberSet.add(number);
        }

        // then
        assertThat(numberList.size()).isEqualTo(numberSet.size());
    }
}