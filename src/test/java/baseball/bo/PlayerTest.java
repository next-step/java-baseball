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

        boolean isLengthTrueValid = (boolean)isValid.invoke(player, "12");
        boolean isLengthTrueValid2 = (boolean)isValid.invoke(player, "");
        boolean isLengthTrueValid3 = (boolean)isValid.invoke(player, "1324789");
        boolean isNumberValid = (boolean)isValid.invoke(player, "1b4");
        boolean isContainZeroValid = (boolean)isValid.invoke(player, "014");
        boolean isHasDupNumberValid = (boolean)isValid.invoke(player, "112");

        // then
        assertThat(isLengthTrueValid).isFalse();
        assertThat(isLengthTrueValid2).isFalse();
        assertThat(isLengthTrueValid3).isFalse();
        assertThat(isNumberValid).isFalse();
        assertThat(isContainZeroValid).isFalse();
        assertThat(isHasDupNumberValid).isFalse();
    }
}