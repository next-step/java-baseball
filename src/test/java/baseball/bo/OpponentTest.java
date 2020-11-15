package baseball.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}