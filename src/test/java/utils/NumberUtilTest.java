package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {

    @Test
    @DisplayName("3자리 난수 생성 로직이 실제로 100~999 사이의 숫자를 생성하는지 확인")
    public void createRandomNumberTest() {
        
        int randomNumber = 0;
        
        for (int i = 0; i <= 50000; i++) {
            randomNumber = (int) ((Math.random() * (999 - 100 + 1)) + 100);
            
            assertThat(randomNumber >= 100 && randomNumber <= 999).isTrue();
            assertThat(randomNumber).isBetween(100, 999);
            
            // (추가) 계산하다보면 앞뒤로 1개씩(여기서는 100, 999) 숫자가 빠지는 경우가 있음.
            // 1. 999가 빠지는 경우 - 정상이면 아래는 실패해야 함.
            //assertThat(randomNumber >= 999).isFalse();
            // 2. 100이 빠지는 경우 - 정상이면 아래는 실패해야 함.
            //assertThat(randomNumber <= 100).isFalse();
        }
        
    }
    
    
    @Test
    @DisplayName("list, indexOf를 활용한 strike, ball 판별 테스트")
    public void listIndexOfTest() {
        
        int strikeCnt = 0;
        int ballCnt   = 0;
        
        Integer[] test       = {3, 2, 7};
        Integer[] comparison = {3, 7, 2};
        
        List<Integer> aList = Arrays.asList(test);
        List<Integer> bList = Arrays.asList(comparison);
        
        for (int i = 0; i < aList.size(); i++) {
            
            int listIndex = bList.indexOf(aList.get(i));
            
            if (listIndex != -1 && listIndex == i) {
                strikeCnt++;
            }
            
            if (listIndex != -1 && listIndex != i) {
                ballCnt++;
            }
        }
        
        assertThat(strikeCnt).isEqualTo(1);
        assertThat(ballCnt).isEqualTo(2);
    }
    
    
    @Test
    @DisplayName("int형 변수를 분해하여 하나씩 array로 넣는 로직 테스트")
    public void intToArrayTest() {
        
        int number = 923;
        
        List<Integer> list = new ArrayList<>();

        while(number != 0) {
            list.add(number % 10);
            number /= 10;
        }
        Collections.reverse(list);

        Integer[] array = list.toArray(new Integer[list.size()]);

        assertThat(array[0]).isEqualTo(9);
        assertThat(array[1]).isEqualTo(2);
        assertThat(array[2]).isEqualTo(3);
    }
    
}