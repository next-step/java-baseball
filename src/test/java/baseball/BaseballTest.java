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

    /** checkScoreTest 컴퓨터의 값과 유저의 값에 따른 결과가 제대로 나오는지 확인하는 테스트 */
    @ParameterizedTest
    @CsvSource({"123,456,낫싱","123,132,1 스트라이크 2 볼","456,456,3 스트라이크"})
    public void checkScoreTest(int setNumber, int inputNumber, String expected){
        Baseball game = new Baseball();
        game.testScore(setNumber);
        game.checkScore(inputNumber);
        assertThat(game.printScore()).isEqualTo(expected);
    }

    /** checkRestartTest 3스트라이크시 제대로 checkRestart가 작동하는지에 대한 테스트 */
    @ParameterizedTest
    @CsvSource({"123,456,true","123,132,true","456,456,false","263,263,false"})
    public void checkRestartTest(int setNumber, int inputNumber, boolean restart){
        Baseball game = new Baseball();
        game.testScore(setNumber);
        game.checkScore(inputNumber);
        assertThat(game.checkRestart()).isEqualTo(restart);
    }
}
