package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberUtilTest {

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
    
}
