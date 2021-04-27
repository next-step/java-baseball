import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class BaseBallTest {

    @Test
    @DisplayName("중복 없는 3자리 숫자 정답 확인")
    void getAnswerTest(){
        BaseBall baseBall = new BaseBall();
        String answer = baseBall.getAnswer();
        String[] arrAnswer = answer.split("");
        assertAll(
                ()->assertNotNull(answer),
                ()->assertEquals(answer.length(),3),
                ()->assertNotEquals(arrAnswer[0],arrAnswer[1], arrAnswer[2])
        );
    }

    //String answer, int check, int index, int[] result
    @ParameterizedTest
    @CsvSource(value = {"123:1:1:1,0", "123:1:2:0,1","123:1:3:0,1","123:-1:0:0,0","123:2:2:1,0"} ,delimiter = ':')
    @DisplayName("스트라이크 볼 판정 테스트")
    void refereeTest(String answer, int check, int index, String result ){
        BaseBall baseBall = new BaseBall();
        //정답 배열로 변환
        String[] strArray = result.split(",");
        int[] expectedArray = new int[strArray.length];
        for (int i = 0; i < strArray.length ; i++) {
            expectedArray[i] = Integer.parseInt(strArray[i]);
        }
        int[] checkResult = baseBall.referee(answer, check, index, new int[]{0,0});
        assertArrayEquals(expectedArray, checkResult);
    }


}
