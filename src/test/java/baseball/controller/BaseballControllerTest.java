package baseball.controller;

import baseball.controller.dto.BaseballGameRequest;
import baseball.controller.dto.BaseballGameResponse;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumberFactory;
import baseball.domain.BaseballNumbers;
import baseball.infra.BaseballDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballControllerTest {

    private BaseballController controller;

    @BeforeEach
    void setUp() {
        controller = new BaseballController();
    }

    @Test
    @DisplayName("게임 시작")
    void start() {
        // given when
        controller.start();
        BaseballNumbers savedData = BaseballDatabase.baseballNumbers;

        // then
        assertThat(savedData).isNotNull();
        assertThat(3).isEqualTo(savedData.size());
    }

    @Test
    @DisplayName("투구 실행")
    void pitch() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();
        List<BaseballNumber> baseballNumbers = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballDatabase.baseballNumbers = new BaseballNumbers(baseballNumbers);

        // when
        BaseballGameRequest gameRequest = new BaseballGameRequest("132");
        BaseballGameResponse gameResponse = controller.pitch(gameRequest);

        // then
        assertThat(1).isEqualTo(gameResponse.getStrikeCount());
        assertThat(2).isEqualTo(gameResponse.getBallCount());
        assertThat(gameResponse.isNothing()).isFalse();
        assertThat(gameResponse.isFinished()).isFalse();
    }

    @Test
    @DisplayName("투구 실행 - 낫싱")
    void pitch_nothing() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();
        List<BaseballNumber> baseballNumbers = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballDatabase.baseballNumbers = new BaseballNumbers(baseballNumbers);

        // when
        BaseballGameRequest gameRequest = new BaseballGameRequest("789");
        BaseballGameResponse gameResponse = controller.pitch(gameRequest);

        // then
        assertThat(0).isEqualTo(gameResponse.getStrikeCount());
        assertThat(0).isEqualTo(gameResponse.getBallCount());
        assertThat(gameResponse.isNothing()).isTrue();
        assertThat(gameResponse.isFinished()).isFalse();
    }

    @Test
    @DisplayName("투구 실행 - 경기 종료")
    void pitch_finish() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();
        List<BaseballNumber> baseballNumbers = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballDatabase.baseballNumbers = new BaseballNumbers(baseballNumbers);

        // when
        BaseballGameRequest gameRequest = new BaseballGameRequest("123");
        BaseballGameResponse gameResponse = controller.pitch(gameRequest);

        // then
        assertThat(3).isEqualTo(gameResponse.getStrikeCount());
        assertThat(0).isEqualTo(gameResponse.getBallCount());
        assertThat(gameResponse.isNothing()).isFalse();
        assertThat(gameResponse.isFinished()).isTrue();
    }
}