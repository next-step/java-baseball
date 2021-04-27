package kr.aterilio.nextstep.techcamp.precourse.baseball;

import kr.aterilio.nextstep.techcamp.precourse.baseball.judge.Judgement;
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
    @CsvSource(value = {"1,2,3/3"}, delimiter = '/')
    public void test_judge(@ConvertWith(IntegerArrayConverter.class) Integer[] arrInputs, int strike) {
        final List<Integer> inputs = Arrays.asList(arrInputs);
        Judgement judgement = baseball.judge(inputs);
        assertThat(judgement.strike()).isEqualTo(strike);
    }
}
