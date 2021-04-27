package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumberFactory;
import baseball.domain.BaseballNumbers;
import baseball.infra.BaseballDatabase;
import baseball.repository.BaseballNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballGameServiceTest {

    private BaseballGameService service;

    @BeforeEach
    void setUp() {
        service = new BaseballGameService();
    }

    @Test
    @DisplayName("게임 시작")
    void start() {
        // given
        BaseballNumberRepository repository = new BaseballNumberRepository();

        // when
        service.start();
        BaseballNumbers baseballNumbers = repository.find();

        // then
        assertThat(3).isEqualTo(baseballNumbers.size());
    }

    @Test
    @DisplayName("투구 실행")
    void pitch() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();
        List<BaseballNumber> baseballNumbers = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballDatabase.baseballNumbers = new BaseballNumbers(baseballNumbers);

        // when
        BaseballGame baseballGame = service.pitch(BaseballNumbers.pitchNumber("132"));

        // then
        assertThat(baseballGame.isFinish()).isFalse();
        assertThat(baseballGame.isNothing()).isFalse();
        assertThat(1).isEqualTo(baseballGame.getStrikeCount());
        assertThat(2).isEqualTo(baseballGame.getBallCount());
    }

    @Test
    @DisplayName("투구실행 - 문자열 입력")
    void pitch_stringInput() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();
        List<BaseballNumber> baseballNumbers = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballDatabase.baseballNumbers = new BaseballNumbers(baseballNumbers);

        // when
        BaseballGame baseballGame = service.pitch("132");

        // then
        assertThat(baseballGame.isFinish()).isFalse();
        assertThat(baseballGame.isNothing()).isFalse();
        assertThat(1).isEqualTo(baseballGame.getStrikeCount());
        assertThat(2).isEqualTo(baseballGame.getBallCount());
    }

    @Test
    @DisplayName("투구실행 - 유효하지 않은 입력")
    void pitch_invalidInput() {
        // given
        BaseballNumberFactory numberFactory = new BaseballNumberFactory();
        List<BaseballNumber> baseballNumbers = numberFactory.generateBaseballNumbers(() -> Arrays.asList(1, 2, 3));
        BaseballDatabase.baseballNumbers = new BaseballNumbers(baseballNumbers);

        // when then
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> service.pitch(" "))
                        .withMessageMatching("숫자 정보를 입력해 주세요."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> service.pitch("AB1"))
                        .withMessageMatching("숫자를 입력해 주세요."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> service.pitch("1234"))
                        .withMessageMatching("숫자는 3 개로 이루어져야 합니다."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> service.pitch("122"))
                        .withMessageMatching("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.")
        );
    }
}