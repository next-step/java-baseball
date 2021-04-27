package baseball;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.ThreeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ListUtil;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameModelTest {

    private static final String USER_INPUT = "123";

    BaseballGameModel sut;
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new ThreeNumberGenerator();
    }

    private void init(String input, String target) {
        sut = new BaseballGameModel(UserInput.of(input), numberGenerator);
        sut.setTarget(Target.of(ListUtil.convertStrToList(target)));
    }

    @ParameterizedTest(name = "사용자입력: {0}, 시스템 입력: {1} > 결과: {2}스{3}볼")
    @CsvSource(value = {
            "123:123:3:0:세 자리 모두 일치",
            "123:312:0:3:세 자리 모두 자리 불일치",
            "123:132:1:2:한 자리 일치, 나머지 두자리 위치 불일치",
            "124:125:2:0:두자리 일치",
            "123:134:1:1:한 자리 일치, 한 자리 위치 불일치",
            "123:342:0:2:두 자리 위치 불일치",
            "134:125:1:0:한 자리 일치",
            "134:356:0:1:한 자리 위치 불일치",
            "134:677:0:0:모든 자리 불일치",
    }, delimiter = ':')
    @DisplayName("사용자 숫자과 시스템 숫자 비교")
    void 사용자_숫자과_시스템_숫자_를_비교한다(String input, String target, int strikeResult, int ballResult) {
        init(input, target);

        GameResult gameResult = sut.guessNumber();

        assertThat(gameResult.getStrike()).isEqualTo(strikeResult);
        assertThat(gameResult.getBall()).isEqualTo(ballResult);
    }

    @Test
    void _3_스트라이크시_게임을_종료() {
        init(USER_INPUT, "123");
        assertThat(sut.isRoundFinished()).isFalse();

        sut.guessNumber();
        assertThat(sut.isRoundFinished()).isTrue();
    }

    @Test
    void 문제를_맞추고_나서_게임_종료() {
        roundOneGameExit();

        sut.selectGame(BaseballGameModel.GAME_EXIT);
        assertThat(sut.isEnd()).isFalse();
    }

    @Test
    void 문제를_맞추고_나서_게임_재시작() {
        roundOneGameExit();

        sut.selectGame(BaseballGameModel.GAME_RESTART);
        assertThat(sut.isEnd()).isTrue();
        assertThat(sut.isRoundFinished()).isFalse();
    }

    private void roundOneGameExit() {
        init("124", "123");
        assertThat(sut.isRoundFinished()).isFalse();
        sut.guessNumber();

        sut.setUserInput(UserInput.of(USER_INPUT));
        sut.guessNumber();

        assertThat(sut.isRoundFinished()).isTrue();
        assertThat(sut.userInput()).isEqualTo(UserInput.of(USER_INPUT));
    }
}