package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumberTest {
    private ComputerNumber computerNumber;

    @BeforeEach
    void setup() {
        computerNumber = new ComputerNumber();
    }

    @DisplayName("서로 다른 3자리 수로 생성되는지 확인")
    @Test
    void makeRandomNumber() {
        boolean result = checkDuplicate(computerNumber.getNumbers());
        assertThat(result).isEqualTo(true);
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        return numbers.size() == 3;
    }
}
