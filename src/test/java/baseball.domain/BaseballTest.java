package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
    private static List<Integer> baseballOverSize = new ArrayList<>();
    private static List<Integer> baseballUnderSize = new ArrayList<>();

    @Test
    @DisplayName("over the three digit exception test")
    public void overTheSize3() {
        for(int i = 1; i < 5; i++) {
            baseballOverSize.add(i);
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Baseball.of(baseballOverSize);
        });
    }

    @Test
    @DisplayName("under the three digit exception test")
    public void underTheSize3() {
        for(int i = 1; i < 2; i++) {
            baseballUnderSize.add(i);
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Baseball.of(baseballUnderSize);
        });
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
