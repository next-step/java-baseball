package baseball;

import common.ShuffleNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ShuffleNumbersTest {


    @Test
    @DisplayName("3가지 숫자가 중복 없이 리턴되는지 테스트")
    public void getShuffleNumbersTest() {
        assertThat(ShuffleNumbers.getShuffledThreeNumbers(new String[] {"1","2","3","4","5","6","7","8","9"}, 3).length()).isEqualTo(3) ;
//        assertThat(ShuffleNumbers.getSuffledThreeNumbers()).doesNotHaveDuplicates() ;
    }
}
