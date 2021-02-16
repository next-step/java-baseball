package baseball.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {
    static Baseball baseball;

    @DisplayName("테스트 시작")
    @BeforeAll
    public static void start(){
        baseball = new Baseball();
        baseball.initGame("123");
    }

    @Test
    public void 랜덤세자릿수생성(){
        Integer randomNumber = baseball.generateRandomNumber();

        assertThat(randomNumber).isBetween(100, 999);
    }

    @Test
    public void 스트라이크3(){
        String numbers = "123";
        baseball.compareNumbers(numbers);
        int expectedBallCount = 0;
        int expectedStrikeCount = 3;

        assertThat(baseball.getPlayerBalls()).isEqualTo(expectedBallCount);
        assertThat(baseball.getPlayerStrikes()).isEqualTo(expectedStrikeCount);
    }

    @Test
    public void 볼2스트라이크1(){
        String numbers = "321";
        baseball.compareNumbers(numbers);
        int expectedBallCount = 2;
        int expectedStrikeCount = 1;

        assertThat(baseball.getPlayerBalls()).isEqualTo(expectedBallCount);
        assertThat(baseball.getPlayerStrikes()).isEqualTo(expectedStrikeCount);
    }

    @Test
    public void 낫싱(){
        String numbers = "555";
        baseball.compareNumbers(numbers);
        int expectedBallCount = 0;
        int expectedStrikeCount = 0;

        assertThat(baseball.getPlayerBalls()).isEqualTo(expectedBallCount);
        assertThat(baseball.getPlayerStrikes()).isEqualTo(expectedStrikeCount);
    }

    @Test
    void getPlayerStrikes() {
        String numbers = "321";
        baseball.compareNumbers(numbers);
        int expectedStrikeCount = 1;

        assertThat(baseball.getPlayerStrikes()).isEqualTo(expectedStrikeCount);
    }

    @Test
    void getPlayerBalls() {
        String numbers = "321";
        baseball.compareNumbers(numbers);
        int expectedBallCount = 2;

        assertThat(baseball.getPlayerBalls()).isEqualTo(expectedBallCount);
    }

    @Test
    void setPlayerNumber(){
        String numbers = "3211";
        assertThatThrownBy( () -> baseball.compareNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세 자리 숫자만 입력 가능합니다.");
    }


}