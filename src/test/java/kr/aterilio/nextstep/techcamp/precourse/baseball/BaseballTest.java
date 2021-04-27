package kr.aterilio.nextstep.techcamp.precourse.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    private final Integer[] TEST_CASE = {1,2,3};
    private Baseball baseball;

    @BeforeEach
    public void setUp() {
        baseball = new Baseball(TEST_CASE);
    }

    @DisplayName("게임 생성 테스트")
    @Test
    public void test_createGame() {
        Baseball game = new Baseball();
        System.out.println(game);
        assertThat(game.isCreated()).isTrue();
    }

    @DisplayName("게임 생성 (지정 케이스) 및 완전 일치 여부 테스트")
    @Test
    public void test_createGame2() {
        final List<Integer> inputs = Arrays.asList(TEST_CASE);
        Judgement judgement = baseball.judge(inputs);
        assertThat(judgement.isClear()).isTrue();
    }

    @DisplayName("판정 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "4,5,6/0/0",                            // nothing
            "1,5,7/1/0", "1,2,8/2/0", "1,2,3/3/0",  // strike
            "5,7,1/0/1", "8,1,2/0/2", "3,1,2/0/3"   // ball
    }, delimiter = '/')
    public void test_judge(@ConvertWith(IntegerArrayConverter.class) Integer[] arrInputs, int strike, int ball) {
        final List<Integer> inputs = Arrays.asList(arrInputs);
        Judgement judgement = baseball.judge(inputs);
        assertThat(judgement.strike()).isEqualTo(strike);
        assertThat(judgement.ball()).isEqualTo(ball);
    }

    @DisplayName("판정 테스트 : 낫싱")
    @Test
    public void test_judgeNothing() {
        final List<Integer> inputs = Arrays.asList(4,5,6);
        Judgement judgement = baseball.judge(inputs);
        assertThat(judgement.isNothing()).isTrue();
    }
}
