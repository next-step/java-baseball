package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    private List<BaseballNumber> opponentNumbers = new ArrayList<>();
    private List<BaseballNumber> playerNumbers = new ArrayList<>();

    @Test
    @DisplayName("3볼 테스트")
    public void ballTest() {
        opponentNumbers.add(new BaseballNumber(1));
        opponentNumbers.add(new BaseballNumber(2));
        opponentNumbers.add(new BaseballNumber(3));
        playerNumbers.add(new BaseballNumber(3));
        playerNumbers.add(new BaseballNumber(1));
        playerNumbers.add(new BaseballNumber(2));
        Result result = new Result(opponentNumbers, playerNumbers);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("3 스트라이크 테스트")
    public void strikeTest() {
        opponentNumbers.add(new BaseballNumber(1));
        opponentNumbers.add(new BaseballNumber(2));
        opponentNumbers.add(new BaseballNumber(3));
        playerNumbers.add(new BaseballNumber(1));
        playerNumbers.add(new BaseballNumber(2));
        playerNumbers.add(new BaseballNumber(3));
        Result result = new Result(opponentNumbers, playerNumbers);
        assertThat(result.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothingTest() {
        opponentNumbers.add(new BaseballNumber(1));
        opponentNumbers.add(new BaseballNumber(2));
        opponentNumbers.add(new BaseballNumber(3));
        playerNumbers.add(new BaseballNumber(4));
        playerNumbers.add(new BaseballNumber(5));
        playerNumbers.add(new BaseballNumber(6));
        Result result = new Result(opponentNumbers, playerNumbers);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("2볼 1스트라이크 믹스 테스트")
    public void mixTest() {
        opponentNumbers.add(new BaseballNumber(1));
        opponentNumbers.add(new BaseballNumber(2));
        opponentNumbers.add(new BaseballNumber(3));
        playerNumbers.add(new BaseballNumber(1));
        playerNumbers.add(new BaseballNumber(3));
        playerNumbers.add(new BaseballNumber(2));
        Result result = new Result(opponentNumbers, playerNumbers);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }
}