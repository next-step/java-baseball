package util;


import domain.BaseballType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


class BaseBallUtilTest {
    int strikeCnt;
    int ballCnt;
    private static final int [] fixedNumber = {1,2,3,4,5,6,7,8,9};
    private Set<Integer> set = new HashSet<>();

    @BeforeEach
    public void setUp(){
        strikeCnt = 2;
        ballCnt = 1;
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    @DisplayName("맵에, 값들이 반영이 잘되나 체킹.")
    void setBaseballMap() {
        Map<String,Integer> resultMap = new HashMap<>();
        resultMap.put(BaseballType.STRIKE.name(),strikeCnt);
        resultMap.put(BaseballType.BALL.name(),ballCnt);
        assertThat(BaseballType.STRIKE.getType()).isEqualTo("스트라이크");
        assertThat(BaseballType.BALL.getType()).isEqualTo("볼");
        assertThat(BaseballType.STRIKE.name()).isEqualTo("STRIKE");
        assertThat(BaseballType.BALL.name()).isEqualTo("BALL");
        assertThat(resultMap.get(BaseballType.STRIKE.name())).isEqualTo(2);
        assertThat(resultMap.get(BaseballType.BALL.name())).isEqualTo(1);
    }

    @Test
    @DisplayName("볼의 카운트 체킹")
    void getBallCount() {
        //변수 값 기준으로, 2가 도출 되어야함.
        int[] computerNumber = {1,2,3};
        int[] userNumber = {2,1,3};
        int ballCnt = 0;


        for(int i = 0; i < computerNumber.length; i++){
            for(int j = 0; j < userNumber.length; j++){
                if(i!=j && computerNumber[i] == userNumber[j]){
                    ballCnt++;
                    break;
                }
            }
        }
            assertThat(ballCnt).isEqualTo(2);
    }

    @Test
    @DisplayName("스트라이크 카운트 체킹")
    void getStrikeCount() {
        int[] computerNumber = {1,2,3};//변수 값 기준으로, 1이 도출 되어야함.
        int[] userNumber = {2,1,3};
        int ballCnt = 0;

        for(int i = 0; i < computerNumber.length; i++){
            for(int j = 0; j < userNumber.length; j++){
                if(i==j && computerNumber[i] == userNumber[j]){
                    ballCnt++;
                    break;
                }
            }
        }
        assertThat(ballCnt).isEqualTo(1);
    }


    @ParameterizedTest
    @CsvSource(value = {"0,5", "1,1", "2,3"})
    @DisplayName("스트링 값,배열로 변환")
    void userNumGenerator(int idx, int value) {
        String input = "513";
        int [] generator = new int[3];

        String [] strArr = input.split("");
        for(int i = 0; i < strArr.length; i++){
            generator[i] = Integer.parseInt(strArr[i]);
        }
        assertThat(generator[idx]).isEqualTo(value);
    }


    @Test
    @DisplayName("Set에 담긴값을 배열에다가 삽입.")
    void numGenerator() {
        int [] generator = new int[3];
        Iterator<Integer> iterator = set.iterator();
        int idx = 0;
        while(iterator.hasNext()){
            generator[idx] = iterator.next();
            idx++;
        }
        assertThat(generator.length).isEqualTo(3);
    }


    @DisplayName("Set을 이용하여 중복숫자를 제외하며 3개의 임의숫자를 부여하여 생성")
    @Test
    void getDeduplicate() {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while(set.size() < 3){
            int n = random.nextInt(9);
            set.add(fixedNumber[n]);
            if(set.size() == 3){
                break;
            }
        }
        assertThat(set.size()).isEqualTo(3);
    }
}