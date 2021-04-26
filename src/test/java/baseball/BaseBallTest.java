package baseball;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class BaseBallTest {

    BaseBall baseBall = new BaseBall();
    private ArrayList<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
    }


    @Test
    @DisplayName("컴퓨터 숫자의 출력값 중복 체크")
    public void checkDuplicateValueTest() {
        int testNumber = 1;
        assertThat(baseBall.checkDuplicateValue(numbers, testNumber)).isFalse();

        testNumber = 2;
        assertThat(baseBall.checkDuplicateValue(numbers, testNumber)).isTrue();

    }

}