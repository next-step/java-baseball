import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballModelTest {

    private static final BaseballModel baseballModel = new BaseballModel();

    @Test
    @DisplayName("정답에 중복된 숫자가 있는지 확인한")
    void testDuplicateBallNumber() {
        baseballModel.initializeBallNumber();
        String ballNumber = baseballModel.getBallNumber();
        Set<Character> characterSet = new HashSet<>();
        for(int index = 0 ; index < ballNumber.length() ; ++index){
            characterSet.add(ballNumber.charAt(index));
        }
        Assertions.assertThat(characterSet.size()).isEqualTo(baseballModel.getLengthOfBallNumber());
    }

}