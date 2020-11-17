package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
    @Test
    @DisplayName("validation(size : over three digit) test")
    public void overTheSize3() {
        List<Integer> integerListBaseball = new ArrayList<>();
        for(int i = 1; i < 5; i++) {
            integerListBaseball.add(i);
        }
        expectIllegalArgumentException(integerListBaseball);
    }

    @Test
    @DisplayName("validation(size : under three digit) test")
    public void underTheSize3() {
        List<Integer> integerListBaseball = new ArrayList<>();
        for(int i = 1; i < 2; i++) {
            integerListBaseball.add(i);
        }
        expectIllegalArgumentException(integerListBaseball);
    }

    @Test
    @DisplayName("numberformat exception test")
    public void inputUnexpectedString() {
        String abNormalInput = "2f3";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Baseball.of(abNormalInput);
        });
    }

    @Test
    @DisplayName("validation(duplication) test")
    public void inputDuplicateNumber() {
        String duplicationInput = "233";
        expectIllegalArgumentException(duplicationInput);
    }

    @Test
    @DisplayName("validation(zero) test")
    public void inputZero() {
        String zeroInput = "230";
        expectIllegalArgumentException(zeroInput);
    }

    @Test
    @DisplayName("validation(zero) test")
    public void oversizeInputString() {
        String oversizeInput = "2312";
        expectIllegalArgumentException(oversizeInput);
    }

    @Test
    @DisplayName("validation(null) test")
    public void inputNull() {
        String nullInput = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            Baseball.of(nullInput);
        });
    }

    private void expectIllegalArgumentException(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Baseball.of(input);
        });
    }

    private void expectIllegalArgumentException(List<Integer> input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Baseball.of(input);
        });
    }

    @Test
    @DisplayName("calculate result test (List<Integer> type)")
    public void matchListType(){
        Baseball answer = Baseball.of(new ArrayList<>(Arrays.asList(4,5,6)));
        Baseball user = Baseball.of(new ArrayList<>(Arrays.asList(1,2,4)));
        Result result = answer.match(user);
        assertThat(result.getStrike().toString()).isEqualTo("0");
        assertThat(result.getBall().toString()).isEqualTo("1");
    }

    @Test
    @DisplayName("calculate result test (String type)")
    public void matchStringType(){
        Baseball answer = Baseball.of("456");
        Baseball user = Baseball.of("124");
        Result result = answer.match(user);
        assertThat(result.getStrike().toString()).isEqualTo("0");
        assertThat(result.getBall().toString()).isEqualTo("1");
    }
}
