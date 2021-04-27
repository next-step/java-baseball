package freecourse1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ScoreTest {

    Score score;
    int[] actualArray;

    @BeforeEach
    void setUp() {
        score = new Score();
        actualArray = new int[]{1, 2, 3};
    }

    @Test
    public void isStrikeTest() {

        int[] expectedArray = {1,2,3};

        score.compare(actualArray, expectedArray );

        assertThat(score.getScore()).isEqualTo("3스트라이크");
        assertThat(score.isSuccess()).isTrue();
    }

    @Test
    public void isScoreCountTest(){

        int[] expectedArray = {9,2,1};

        score.compare(actualArray, expectedArray);
        assertThat(score.getStrikeCount()).isEqualTo(1);
        assertThat(score.getBallCount()).isEqualTo(1);
    }

}
