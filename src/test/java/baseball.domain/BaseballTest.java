package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void underTheSize3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Baseball.of(baseballUnderSize);
        });
    }
}
