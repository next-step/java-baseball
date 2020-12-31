package baseball;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballTest {
    static int LEN = 3;
    private boolean testTen(int n){
        if (n>= 0 && n < 10){
            return true;
        }
        return false;
    }
    /** makeNumberTest 클래스 생성 및 게임의 숫자가 제대로 생성되었는지 확인하는 테스트 */
    @Test
    public void makeNumberTest(){
        Baseball game = new Baseball();
        int [] num = game.testNumber();

        for (int i = 0; i < LEN; i++){
            assertThat(testTen(num[i])).isTrue();
            assertThat(num[i]).isNotEqualTo(num[(i+1)%LEN]);
        }
    }
}
