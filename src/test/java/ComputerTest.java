import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;


import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setUpComputer() {
        computer = new Computer();
    }

    @Test
    public void isRandomNumbersNotNullWhichIsGeneratedBySelectRandomNumberMethod() {
        computer.selectRandomNumber();
        ArrayList<Integer> hiddenNumbers = computer.getHiddenNumbers();
        assertThat(hiddenNumbers)
                .as("should not be null")
                .isNotNull();
    }

    @Test
    public void isSizeOfRandomNumbersValidate() {
        computer.selectRandomNumber();
        ArrayList<Integer> hiddenNumbers = computer.getHiddenNumbers();
        assertThat(hiddenNumbers.size())
                .as("failure - digit of hiddenNumber must be 3")
                .isEqualTo(Computer.NUMBER_OF_DIGIT);
    }

    @Test
    public void isEachNumberOfRandomNumbersConsistNumber1To9() {
        computer.selectRandomNumber();
        ArrayList<Integer> hiddenNumbers = computer.getHiddenNumbers();
        for (Integer number : hiddenNumbers) {
            assertThat(number)
                    .as("failure - number should be between 1 to 9 ")
                    .isBetween(1, 9);
        }
    }

    @Test
    public void isEachNumberAreDifferent() {
        computer.selectRandomNumber();
        ArrayList<Integer> hiddenNumbers = computer.getHiddenNumbers();
        HashSet<Integer> uniqueNumberCounter = new HashSet<Integer>();
        for (Integer number : hiddenNumbers) {
            uniqueNumberCounter.add(number);
        }
        assertThat(uniqueNumberCounter.size())
                .as("failure - Each number should be unique")
                .isEqualTo(Computer.NUMBER_OF_DIGIT);
    }

    @Test
    public void ballCountTest() {
        computer.setHiddenNumbers("123");
        assertThat(computer.guessNumber("456")
                .getBall()).as("failure - miscount ball")
                .isEqualTo(0);

        assertThat(computer.guessNumber("321")
                .getBall()).as("failure - miscount ball")
                .isEqualTo(2);

        assertThat(computer.guessNumber("123")
                .getBall()).as("failure - miscount ball")
                .isEqualTo(0);

        assertThat(computer.guessNumber("932")
                .getBall()).as("failure - miscount ball")
                .isEqualTo(2);

        assertThat(computer.guessNumber("231")
                .getBall()).as("failure - miscount ball")
                .isEqualTo(3);

        assertThat(computer.guessNumber("415")
                .getBall()).as("failure - miscount ball")
                .isEqualTo(1);
    }

    @Test
    public void strikeCountTest() {
        computer.setHiddenNumbers("123");
        assertThat(computer.guessNumber("456")
                .getStrike()).as("failure - miscount strike")
                .isEqualTo(0);

        assertThat(computer.guessNumber("321")
                .getStrike()).as("failure - miscount strike")
                .isEqualTo(1);

        assertThat(computer.guessNumber("123")
                .getStrike()).as("failure - miscount strike")
                .isEqualTo(3);

        assertThat(computer.guessNumber("234")
                .getStrike()).as("failure - miscount strike")
                .isEqualTo(0);

        assertThat(computer.guessNumber("153")
                .getStrike()).as("failure - miscount strike")
                .isEqualTo(2);

        assertThat(computer.guessNumber("932")
                .getStrike()).as("failure - miscount strike")
                .isEqualTo(0);
    }
}