package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.repository.BaseballNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        BaseballNumberRepository repository = new BaseballNumberRepository();

        // when
        repository.save(BaseballNumbers.pitchNumber("123"));
        BaseballGame baseballGame = service.pitch(BaseballNumbers.pitchNumber("132"));

        // then
        assertThat(baseballGame.isFinish()).isFalse();
        assertThat(baseballGame.isNothing()).isFalse();
        assertThat(1).isEqualTo(baseballGame.getStrikeCount());
        assertThat(2).isEqualTo(baseballGame.getBallCount());
    }
}