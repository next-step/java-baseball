package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallCountTest {

    @ParameterizedTest
    @CsvSource({
            "'123', '123', 3, 0",
            "'143', '123', 2, 0",
            "'123', '245', 0, 1",
            "'321', '341', 2, 0",
            "'158', '851', 1, 2",
            "'789', '978', 0, 3",
    })
    @DisplayName("자릿수의 위치와 숫자 값이 같으면 스트라이크 카운팅이되고, 자릿수가 다르지만 숫자가값이 같으면 볼 카운팅이된다.")
    void strikeTest(String c, String u, int exceptedStrikeCount, int exceptedBallCount) {
        // 실제 컴퓨터는 램더어블을 사용하지만, 테스트에 적합하지 않으므로 유저용 구현체 사용
        BaseBallNumbers computer = new InputableBaseBallNumbers(c);
        BaseBallNumbers user = new InputableBaseBallNumbers(u);
        BaseBallCount count = BaseBallCount.of(computer, user);
        assertThat(count.getStrike()).isEqualTo(exceptedStrikeCount);
        assertThat(count.getBall()).isEqualTo(exceptedBallCount);
    }

    @ParameterizedTest
    @CsvSource({
            "'123', '123'",
            "'143', '143'",
            "'321', '321'",
            "'158', '158'",
            "'789', '789'",
    })
    @DisplayName("세자리수 모두 자릿수 위치와 값이 같다면 스트라이크가 세번 카운팅되고, 쓰리스트라이크는 참을 반환한다.")
    void threeStrikeTest(String c, String u) {
        BaseBallNumbers computer = new InputableBaseBallNumbers(c);
        BaseBallNumbers user = new InputableBaseBallNumbers(u);
        BaseBallCount count = BaseBallCount.of(computer, user);
        assertThat(count.isThreeStrike()).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "'789', '987', '1 스트라이크 2볼'",
            "'123', '123', '3 스트라이크'",
            "'143', '123', '2 스트라이크'",
            "'321', '145', '1볼'",
            "'158', '815', '3볼'",
            "'321', '789', '낫싱'",
            "'123', '458', '낫싱'",
    })
    @DisplayName("스트라이크와 볼 카운팅된 내용을 구현 기능목록에 정의해놓은 포맷팅 규격에 맞게 포맷한다.")
    void countStringFormatTest(String c, String u, String exceptedFormattedString) {
        BaseBallNumbers computer = new InputableBaseBallNumbers(c);
        BaseBallNumbers user = new InputableBaseBallNumbers(u);
        BaseBallCount count = BaseBallCount.of(computer, user);
        assertThat(count.toString()).isEqualTo( exceptedFormattedString);
    }
}