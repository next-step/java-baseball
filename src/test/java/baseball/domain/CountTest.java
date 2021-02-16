package baseball.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountTest {
    static Count count;

    @BeforeAll
    static void start(){
        count= new Count();
    }
    @Test
    void getCount() {
        count= new Count();
        assertThat(count.getCount()).isEqualTo(0);
    }

    @Test
    void increase() {
        count.increase(1);
        assertThat(count.getCount()).isEqualTo(1);
        count.increase(0);
        assertThat(count.getCount()).isEqualTo(1);
    }


    @Test
    void increaseException() {
        assertThatThrownBy( () -> count.increase(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값 증가에 음수는 허용되지 않습니다.");
    }
}