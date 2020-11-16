package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.configuration.BaseballConfiguration;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 야구 게임 유틸 테스트")
public class BaseballUtilTest {


    @DisplayName("랜덤 함수 생성 > 성공")
    @Test
    public void getRandomNumber(){

        String[] numbers = BaseballUtil.getRandomNumbers();

        assertEquals(3, numbers.length);
        assertEquals(true, isRangeNumber(numbers));
        assertEquals(false, isIncludeDuplicateNumber(numbers));

    }
    private boolean isRangeNumber(String[] numbers){

        for(String num : numbers){
            int number = Integer.parseInt(num);
            if(number < BaseballConfiguration.MIN_NUMBER || number > BaseballConfiguration.MAX_NUMBER){
                return false;
            }
        }
        return true;
    }
    private boolean isIncludeDuplicateNumber(String[] numbers){
        HashSet<String> set = new HashSet<>();
        for(String num : numbers){
            set.add(num);
        }
        if(set.size() != BaseballConfiguration.REQUIRED_COUNT){
            return true;
        }
        return false;
    }
}