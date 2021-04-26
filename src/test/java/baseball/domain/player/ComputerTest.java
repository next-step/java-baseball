package baseball.domain.player;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터 도메인 테스트")
class ComputerTest {

    @RepeatedTest(10)
    @DisplayName("야구게임 숫자 모음 생성")
    @Test
    void 야구게임_숫자_모음_생성() {
        // given
        BaseballNumbers baseballNumbers = BaseballNumbersProvider.provideBaseballNumbers();
        // when
        Computer computer = new Computer(baseballNumbers);
        // then
        assertThat(baseballNumbers.getSize()).isEqualTo(3);
    }

}