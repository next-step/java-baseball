package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {

    int[] computerNumber;
    int strike = 0;
    int ball = 0;

    @BeforeEach
    void setArray(){
        computerNumber = new int[3];
        computerNumber[0] = 4;
        computerNumber[1] = 2;
        computerNumber[2] = 5;
    }

    @DisplayName("스트라이크 기능 테스트. ")
    @Test
    public void 스트라이크_기능_테스트(){

        String custNums = "123";

        for(int i = 0 ; i < computerNumber.length; i++){
            String tmp = String.valueOf(custNums.charAt(i));
            strike += getEqual(computerNumber[i], Integer.parseInt(tmp));
        }

        assertThat(strike).isEqualTo(1);
    }

    @DisplayName("볼 기능 테스트. ")
    @Test
    public void 볼_기능_테스트(){

        String custNums = "145";

        for(int i = 0 ; i < computerNumber.length; i++){
            getBall(i, computerNumber[i], custNums);
        }

        assertThat(ball).isEqualTo(1);
    }

    /*
        같으면 return 1 , 아니면 return 0
     */
    private int getEqual(int com, int cust){
        return com == cust ? 1 : 0;
    }

    /*
        볼 카운팅 기능.
     */
    private void getBall(int idx, int coms, String cust){
        for(int j = 0 ; j < cust.length(); j++){
            int custNum = Integer.parseInt(String.valueOf(cust.charAt(j)));
            ball += getNotEqualIdxTwoParams(idx, j, coms, custNum);
        }
    }

    /*
        두 인덱스가 같지 않을때 값 비교
     */
    private int getNotEqualIdxTwoParams(int idx, int idx2, int com, int cust){
        if(idx != idx2 ){
            return getEqual(com, cust);
        }
        return 0;
    }





}
