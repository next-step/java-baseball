package baseball.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class OpponentTest {

    @Test
    @DisplayName("Strike number 생성 테스트 - 숫자 정상 생성")
    void generateStrikeNumber() {

        // given
        Opponent opponent = new Opponent();

        // when
        String strikeNumber = opponent.getStrikeNumber();

        // then
        assertThat(strikeNumber.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("Strike number 생성 테스트 - 숫자 중복생성여부")
    void checkExistDupNum() {

        // given
        Opponent opponent = new Opponent();

        // when
        String strikeNumber = opponent.getStrikeNumber();

        Set<String> stringSet = new HashSet<>();
        for (char c : strikeNumber.toCharArray()) {
            stringSet.add(String.valueOf(c));
        }

        // then
        assertThat(stringSet.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Strike number 생성 테스트 - 숫자 0생성여부")
    void checkExistZeroNum() {

        // given
        Opponent opponent = new Opponent();

        // when
        String strikeNumber = opponent.getStrikeNumber();

        Set<String> stringSet = new HashSet<>();
        for (char c : strikeNumber.toCharArray()) {
            stringSet.add(String.valueOf(c));
        }

        // then
        assertThat(stringSet.contains("0")).isFalse();
    }

    @Test
    @DisplayName("스트라이크 계산로직 테스트")
    void calculateStrike() throws IllegalAccessException, NoSuchFieldException {
        // given
        Opponent opponent = new Opponent();

        // when
        Field field = opponent.getClass().getDeclaredField("strikeNumber");
        field.setAccessible(true);
        field.set(opponent, "425");

        // then
        opponent.calculateStrike("123");
        assertThat(opponent.getStrike()).isEqualTo(1);
        assertThat(opponent.getBall()).isEqualTo(0);
        assertThat(opponent.getMessage()).isEqualTo("1 스트라이크");

        opponent.calculateStrike("423");
        assertThat(opponent.getStrike()).isEqualTo(2);
        assertThat(opponent.getBall()).isEqualTo(0);
        assertThat(opponent.getMessage()).isEqualTo("2 스트라이크");

        opponent.calculateStrike("456");
        assertThat(opponent.getStrike()).isEqualTo(1);
        assertThat(opponent.getBall()).isEqualTo(1);
        assertThat(opponent.getMessage()).isEqualTo("1 스트라이크 1 볼");

        opponent.calculateStrike("789");
        assertThat(opponent.getStrike()).isEqualTo(0);
        assertThat(opponent.getBall()).isEqualTo(0);
        assertThat(opponent.getMessage()).isEqualTo("낫싱");

        opponent.calculateStrike("425");
        assertThat(opponent.getStrike()).isEqualTo(3);
        assertThat(opponent.getBall()).isEqualTo(0);
        assertThat(opponent.getMessage()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
