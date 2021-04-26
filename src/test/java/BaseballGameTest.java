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

    /**
     * checkStrike
     * 타겟 난수 map, 입력 map을 해당 숫자와 비교하여 스트라이크 여부 확인하는지 테스트
     * @param targets 타겟 난수 map
     * @param inputs 플레이어로부터 입력받은 map
     * @param num 비교 대상 숫자 1~9
     * @param expected 예측 결과
     */
    @ParameterizedTest
    @MethodSource("provideCheckStrikeParameters")
    public void checkStrike(HashMap<Integer,Integer> targets, HashMap<Integer,Integer> inputs, int num, int expected) {
        assertEquals(baseballGame.checkStrike(targets,inputs,num),expected);
    }


    private static Stream<Arguments> provideCheckStrikeParameters(){
        HashMap<Integer,Integer> target1 = new HashMap<>();
        HashMap<Integer,Integer> inputs1 = new HashMap<>();
        target1.put(4,0);
        target1.put(7,1);
        target1.put(2,2);
        inputs1.put(8,0);
        inputs1.put(7,1);
        inputs1.put(2,2);


        return Stream.of(
                Arguments.of(target1,inputs1,2,1),
                Arguments.of(target1,inputs1,4,0),
                Arguments.of(target1,inputs1,7,1),
                Arguments.of(target1,inputs1,8,0)
        );
    }

    /**
     * checkBall
     * 타겟 난수 map, 입력 map을 해당 숫자와 비교하여 볼 여부 확인하는지 테스트
     * @param targets 타겟 난수 map
     * @param inputs 플레이어로부터 입력받은 map
     * @param num 비교 대상 숫자 1~9
     * @param expected 예측 결과
     */
    @ParameterizedTest
    @MethodSource("provideCheckBallParameters")
    public void checkBall(HashMap<Integer,Integer> targets, HashMap<Integer,Integer> inputs, int num, int expected) {
        assertEquals(baseballGame.checkBall(targets,inputs,num),expected);
    }

    private static Stream<Arguments> provideCheckBallParameters(){
        HashMap<Integer,Integer> target1 = new HashMap<>();
        HashMap<Integer,Integer> inputs1 = new HashMap<>();
        target1.put(1,0);
        target1.put(2,1);
        target1.put(3,2);
        inputs1.put(2,0);
        inputs1.put(3,1);
        inputs1.put(5,2);


        return Stream.of(
                Arguments.of(target1,inputs1,1,0),
                Arguments.of(target1,inputs1,2,1),
                Arguments.of(target1,inputs1,3,1),
                Arguments.of(target1,inputs1,4,0)
        );
    }

    /**
     * checkNumbers
     * 타겟 map과 입력 map을 비교하여 종료 가능 여부(3스트라이크) 확인하는지 테스트
     * @param targets 타겟 난수 map
     * @param inputs 플레이어로부터 입력받은 map
     * @param expected 예측 결과
     */
    @ParameterizedTest
    @MethodSource("provideCheckNumbersParameters")
    public void checkNumbers(HashMap<Integer,Integer> targets, HashMap<Integer,Integer> inputs,boolean expected) {
        assertEquals(baseballGame.checkNumbers(targets,inputs),expected);
    }

    private static Stream<Arguments> provideCheckNumbersParameters(){
        HashMap<Integer,Integer> target1 = new HashMap<>();
        HashMap<Integer,Integer> inputs1 = new HashMap<>();
        target1.put(1,0);
        target1.put(2,1);
        target1.put(3,2);
        inputs1.put(1,0);
        inputs1.put(2,1);
        inputs1.put(3,2);
        HashMap<Integer,Integer> target2 = new HashMap<>();
        HashMap<Integer,Integer> inputs2 = new HashMap<>();
        target2.put(1,0);
        target2.put(2,1);
        target2.put(3,2);
        inputs2.put(2,0);
        inputs2.put(3,1);
        inputs2.put(4,2);
        HashMap<Integer,Integer> target3 = new HashMap<>();
        HashMap<Integer,Integer> inputs3 = new HashMap<>();
        target3.put(1,0);
        target3.put(2,1);
        target3.put(3,2);
        inputs3.put(4,0);
        inputs3.put(5,1);
        inputs3.put(6,2);
        HashMap<Integer,Integer> target4 = new HashMap<>();
        HashMap<Integer,Integer> inputs4 = new HashMap<>();
        target4.put(1,0);
        target4.put(2,1);
        target4.put(3,2);
        inputs3.put(4,0);
        inputs3.put(5,1);

        return Stream.of(
                Arguments.of(target1,inputs1,true),
                Arguments.of(target2,inputs2,false),
                Arguments.of(target3,inputs3,false),
                Arguments.of(target4,inputs4,false)
        );
    }
}
