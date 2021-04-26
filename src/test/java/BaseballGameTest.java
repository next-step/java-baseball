import org.hamcrest.junit.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BaseballGameTest {
    BaseballGame baseballGame;
    @BeforeEach
    public void setUp() {
        baseballGame = new BaseballGame();
    }

    /**
     * getRandomNumber
     * 1~10 범위 내에서 각 자릿수가 중복되지 않고 생성 되는지 테스트
     */
    @Test
    public void getRandomNumber() {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = baseballGame.getRandomNumber(map);
        MatcherAssert.assertThat((res>0)&&(res<10), is(Boolean.TRUE));
        map.put(res,0);
        res = baseballGame.getRandomNumber(map);
        MatcherAssert.assertThat((res>0)&&(res<10), is(Boolean.TRUE));
        map.put(res,1);
        res = baseballGame.getRandomNumber(map);
        MatcherAssert.assertThat((res>0)&&(res<10), is(Boolean.TRUE));
        map.put(res,2);
        assertEquals(map.size(),3); //각 Key(값)와 Value(인덱스)가 중복되지 않을 경우 사이즈는 3
    }

    /**
     * initTargetNumbers
     * 세 자리의 HashMap이 중복되지 않고 생성하는지 테스트
     */
    @Test
    public void initTargetNumbers() {
        assertEquals(baseballGame.initTargetNumbers().size(), 3);
    }

    /**
     * convertStringToNumbers
     * 입력받은 숫자를 Key(값)과 Value(인덱스)로 변환하는지 테스트
     * @param str 플레이어로부터 입력받은 숫자
     * @param expected 예측되는 결과값
     */
    @ParameterizedTest
    @MethodSource("provideCSTNParameters")
    public void convertStringToNumbers(String str, int expected) {
        assertEquals(baseballGame.convertStringToNumbers(str).size(), expected);
    }

    private static Stream<Arguments> provideCSTNParameters(){
        return Stream.of(
                Arguments.of("239",3),
                Arguments.of("78",2),
                Arguments.of("3492",4)
        );
    }

}
