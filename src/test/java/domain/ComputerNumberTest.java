package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        boolean result = checkDuplicate(computerNumber.getNumber());
        assertThat(result).isEqualTo(true);
    }

    private boolean checkDuplicate(String number) {
        List<String> splitList = Arrays.asList(number.split(""));
        Set<String> numbers = new HashSet<>(splitList);

        return numbers.size() == 3;
    }
}
