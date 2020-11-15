package baseball.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    @DisplayName("플레이어 숫자입력 validation 테스트")
    void inputStrikeNum() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

         // given
        Player player = new Player();
        Method isValid = Player.class.getDeclaredMethod("isValid", String.class);

        /// when
        isValid.setAccessible(true);

        boolean isLengthTrue = (boolean)isValid.invoke(player, "12");
        boolean isLengthTrue2 = (boolean)isValid.invoke(player, "");
        boolean isLengthTrue3 = (boolean)isValid.invoke(player, "1324789");
        boolean isNumber = (boolean)isValid.invoke(player, "1b4");
        boolean isContainZero = (boolean)isValid.invoke(player, "014");
        boolean isHasDupNumber = (boolean)isValid.invoke(player, "0");

        // then
        assertThat(isLengthTrue).isFalse();
        assertThat(isLengthTrue2).isFalse();
        assertThat(isLengthTrue3).isFalse();
        assertThat(isNumber).isFalse();
        assertThat(isContainZero).isFalse();
        assertThat(isHasDupNumber).isFalse();
    }
}