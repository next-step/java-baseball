package model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ResultTest {

    @Test
    @DisplayName("Three Strike Test")
    public void compareTest1() {
        Result result = new Result();
        List<Integer> answer = Arrays.asList(3,4,1);
        List<Integer> threeStrike = Arrays.asList(3,4,1);
        result.compare(answer, threeStrike);

        assertAll(
                () -> assertThat(result.getStrike()).as("Strike count have to be 3").isEqualTo(3),
                () -> assertThat(result.getBall()).as("Ball count have to be 0").isEqualTo(0)

        );
    }

    @Test
    @DisplayName("One Strike Test")
    public void compareTest2() {
        Result result = new Result();
        List<Integer> answer = Arrays.asList(3,4,1);
        List<Integer> oneStrike = Arrays.asList(3,2,9);
        result.compare(answer, oneStrike);

        assertAll(
                () -> assertThat(result.getStrike()).as("Strike count have to be 1").isEqualTo(1),
                () -> assertThat(result.getBall()).as("Ball count have to be 0").isEqualTo(0)
        );
    }

    @Test
    @DisplayName("Nothing Test")
    public void compareTest3() {
        Result result = new Result();
        List<Integer> answer = Arrays.asList(3,4,1);
        List<Integer> nothing = Arrays.asList(7,8,9);

        result.compare(answer, nothing);

        assertAll(
                () -> assertThat(result.getStrike()).as("Strike count have to be 0").isEqualTo(0),
                () -> assertThat(result.getBall()).as("Ball count have to be 0").isEqualTo(0)
                );
    }

    @Test
    @DisplayName("Three Ball Test")
    public void compareTest4() {
        Result result = new Result();
        List<Integer> answer = Arrays.asList(3,4,1);
        List<Integer> threeBall = Arrays.asList(4,1,3);
        result.compare(answer, threeBall);

        assertAll(
                () -> assertThat(result.getStrike()).as("Strike count have to be 0").isEqualTo(0),
                () -> assertThat(result.getBall()).as("Ball count have to be 3").isEqualTo(3)
        );
    }

    @Test
    @DisplayName("One strike and Two ball Test")
    public void compareTest5() {
        Result result = new Result();
        List<Integer> answer = Arrays.asList(3,4,1);
        List<Integer> oneStrikeTwoBall =  Arrays.asList(3,1,4);
        result.compare(answer, oneStrikeTwoBall);

        assertAll(
                () -> assertThat(result.getStrike()).as("Strike count have to be 1").isEqualTo(1),
                () -> assertThat(result.getBall()).as("Ball count have to be 2").isEqualTo(2)
        );
    }

}