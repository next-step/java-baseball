package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @DisplayName("결과값 정상 저장 여부 테스트 - 스트라이크")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void countStrike(int strikeCount) {
        List<Record> records = new ArrayList<>();
        for (int i = 0; i < strikeCount; i++) {
            records.add(Record.STRIKE);
        }
        result.put(records);

        assertThat(result.countStrike()).isEqualTo(strikeCount);
    }

    @DisplayName("결과값 정상 저장 여부 테스트 - 볼")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void countBall(int ballCount) {
        List<Record> records = new ArrayList<>();
        for (int i = 0; i < ballCount; i++) {
            records.add(Record.BALL);
        }
        result.put(records);

        assertThat(result.countBall()).isEqualTo(ballCount);
    }

    @DisplayName("결과값 정상 저장 여부 테스트 - 낫싱")
    @Test
    void isNothing() {
        List<Record> records = new ArrayList<>();
        result.put(records);

        assertThat(result.isNothing()).isTrue();
    }

    @DisplayName("결과값 정상 저장 여부 테스트 - 게임 종료(스트라이크 3개)")
    @Test
    void isEnd() {
        List<Record> records = Arrays.asList(Record.STRIKE, Record.STRIKE, Record.STRIKE);
        result.put(records);

        assertThat(result.isEnd()).isTrue();
    }
}
