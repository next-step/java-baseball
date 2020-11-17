package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumbersTest {
    private ComputerNumbers computerNumbers;

    @BeforeEach
    void setup() {
        computerNumbers = new ComputerNumbers();
    }

    @DisplayName("크기가 3이면 서로 다른 3자리 수로 생성된거다.")
    @Test
    void makeRandomNumber() {
        boolean result = computerNumbers.getComputerNumbers().size() == 3;
        assertThat(result).isEqualTo(true);
    }
}
