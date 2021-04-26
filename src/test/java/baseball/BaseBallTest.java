package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {

    BaseBall baseBall = new BaseBall();

    @Test
    public void 컴퓨터() {
        System.out.println(baseBall.getRandomValue());
    }

    @Test
    @DisplayName("컴퓨터 숫자의 출력값 중복 체크")
    public void checkDuplicateValueTest() {
        assertThat(baseBall.validateNumber("123")).isTrue();
        assertThat(baseBall.validateNumber("222")).isFalse();
        assertThat(baseBall.validateNumber("090")).isFalse();
    }

}