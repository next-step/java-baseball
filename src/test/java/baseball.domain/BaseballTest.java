package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
    private static List<Integer> baseballOverSize = new ArrayList<>();
    private static List<Integer> baseballUnderSize = new ArrayList<>();

    @BeforeAll
    public static void setup() {
        for(int i = 1; i < 5; i++) {
            baseballOverSize.add(i);
        }
        for(int i = 1; i < 2; i++) {
            baseballUnderSize.add(i);
        }
    }

    @Test
    @DisplayName("exception test")
    public void overTheSize3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Baseball.of(baseballOverSize);
        });
    }

    @Test
    @DisplayName("exception test")
    public void underTheSize3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Baseball.of(baseballUnderSize);
        });
    }

    @Test
    @DisplayName("calculate result test")
    public void match(){
        Baseball answer = Baseball.of(new ArrayList<>(Arrays.asList(4,5,6)));
        Baseball user = Baseball.of(new ArrayList<>(Arrays.asList(1,2,4)));
        Result result = answer.match(user);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);

    }

}
