import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayBaseballUtilTest {
    
    @DisplayName("숫자의 동일성 테스트 - 3자리 숫자내 같은 숫자가 있는 지 확인")
    @Test
    void checkNumberIdentifyTest() {
        PlayBaseballUtil playBaseballUtil = new PlayBaseballUtil();

        assertThat(playBaseballUtil.checkNumberIdentify(123)).isFalse();
        assertThat(playBaseballUtil.checkNumberIdentify(437)).isFalse();
        assertThat(playBaseballUtil.checkNumberIdentify(248)).isFalse();

        assertThat(playBaseballUtil.checkNumberIdentify(355)).isTrue();
        assertThat(playBaseballUtil.checkNumberIdentify(525)).isTrue();
        assertThat(playBaseballUtil.checkNumberIdentify(332)).isTrue();
    }

    @DisplayName("램덤 숫자 테스트 - 램덤 숫자 생성시 자리수 맞는 지 확인")
    @Test
    void getRandomNumberTest() {
        PlayBaseballUtil playBaseballUtil = new PlayBaseballUtil();

        for(int i = 0; i < 20; i++){
            assertThat(playBaseballUtil.getRandomNumber(3)).isNotNull().isNotZero().
                    isPositive().isBetween(102,987);
        }
    }

    @DisplayName("램덤 숫자 동일성 테스트 - 램덤 숫자 생성시 같은 숫자가 없는 지 확인")
    @Test
    void getRandomNumberIdentifyTest() {
        PlayBaseballUtil playBaseballUtil = new PlayBaseballUtil();

        for(int i = 0; i < 20; i++){
            assertThat(playBaseballUtil.checkNumberIdentify(playBaseballUtil.getRandomNumber(3))).isFalse();
        }
    }

    @DisplayName("배팅 결과 테스트 - 2개의 3자리 숫자에 따라 스트라이크, 볼 카운트 결과가 맞는 지 확인")
    @Test
    void getBattingResultTest() {
        PlayBaseballUtil playBaseballUtil = new PlayBaseballUtil();

        assertThat(playBaseballUtil.getBattingResult(123,123)).containsExactly(3,0);
        assertThat(playBaseballUtil.getBattingResult(234,235)).containsExactly(2,0);
        assertThat(playBaseballUtil.getBattingResult(342,243)).containsExactly(1,2);
        assertThat(playBaseballUtil.getBattingResult(548,853)).containsExactly(0,2);
        assertThat(playBaseballUtil.getBattingResult(123,456)).containsExactly(0,0);
    }

}
