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
        boolean result = checkDuplicate(computerNumber.getNumber(), 3);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("0이 포함되는지 확인")
    @Test
    void checkZero() {
        boolean result = computerNumber.getNumber().contains("0");
        assertThat(result).isEqualTo(false);
    }

    private boolean checkDuplicate(String number, int numberLength) {
        Set<String> numbers = new HashSet<>();
        List<String> splitList = Arrays.asList(number.split(""));
        for (String s : splitList) {
            numbers.add(s);
        }

        if (numbers.size() != numberLength) {
            return false;
        }
        return true;
    }
}