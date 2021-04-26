package start.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class BaseBallTest {
    private BaseBallImpl game;
    
    @BeforeEach
    public void setting() {
        game = new BaseBallImpl();
    }
    
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName(value = "1과 9사이의 숫자가 뽑혀야 한다.")
    public void getOneDigitNumberTest() {
        assertThat(game.getOneDigitNumber(1, 9))
            .isNotNull()
            .isGreaterThanOrEqualTo(1)
            .isLessThanOrEqualTo(9);
    }
    
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName(value = "1과 9사이의 숫자 중  중복되지 않는 3자리의 수가 뽑혀야 한다.")
    public void getNonDuplicatedThreeDigitNumberTest() {
        int number = game.getNonDuplicatedThreeDigitNumber(1, 9);
        Set<Integer> result = new HashSet<>();
        for( int index = 2; index >= 0; index-- ) {
            int digit = number % 10;
            result.add(digit);
            number -= digit;
            number /= 10;
        }
        
        assertThat(result.size())
            .isEqualTo(3);
    }
    
}
