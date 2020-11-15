package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("각각 중복되지 않는 세자리 숫자를 생성한다.")
    void 난수는각각중복되지않는세자리숫자() {
        for (int i = 0; i < 100000; i++) {
            //given
            Integer notDuplicatedEachHundredNumber = new NumberGenerator().getNotDuplicatedEachHundredNumber();

            char[] chars = notDuplicatedEachHundredNumber.toString().toCharArray();
            Set<Character> set = new HashSet<>();
            for (char eachNumber : chars) {
                set.add(eachNumber);
            }

            //when,then
            assertThat(set.size()).isEqualTo(3);
            assertThat(notDuplicatedEachHundredNumber).isGreaterThan(0).isLessThan(999);
        }
    }

    @Test
    @DisplayName("게임 판정 테스트")
    void 유저승게임판정테스트() {
        //gvien
        Referee referee = new Referee(123);

        //when
        boolean playerWin = referee.isPlayerWin(123);

        //then
        assertThat(playerWin).isTrue();
    }

    @Test
    @DisplayName("게임 판정 테스트")
    void 유저패게임판정테스트() {
        //gvien
        Referee referee = new Referee(123);

        //when
        boolean playerWin = referee.isPlayerWin(456);

        //then
        assertThat(playerWin).isFalse();
    }

}
