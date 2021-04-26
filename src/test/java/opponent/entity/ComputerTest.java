package opponent.entity;

import baseball.BaseballNumber;
import opponent.Opponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private final Opponent opponent = new Computer();
    private List<BaseballNumber> baseballNumbers;

    @BeforeEach
    void setUp() {
        baseballNumbers = opponent.generateAnswer();
    }

    @Test
    @DisplayName("컴퓨터가 생성한 BaseballNumbers 의 크기가 3인지 확인한다.")
    public void checkBaseballNumbersSize() {
        assertThat(baseballNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 BaseballNumbers 에 중복 숫자가 없는지 확인한다.")
    public void checkBaseballNumbersDuplicate() {
        Set<BaseballNumber> setNumbers = new HashSet<>(baseballNumbers);
        System.out.println(setNumbers.size());
        assertThat(baseballNumbers.size()).isEqualTo(setNumbers.size());
    }

    @Test
    @DisplayName("랜덤 숫자 생성기가 1~9 안에서 숫자를 생성하는지 확인한다.")
    void createRandomNumber(){
        int number = 0;
        for(int i = 0; i < 100; i++){
            number = (int) (Math.random() * 9) + 1;
            assertTrue(1 <= number && number <= 9);
        }
    }

}