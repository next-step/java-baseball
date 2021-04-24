package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {
    
    @Test
    @DisplayName("각 자릿수를 배열에 저장하는 로직 테스트")
    public void digitValidationTest() {
        
        int digit   = 3;   // 3자리 숫자
        int number  = 954; // 각각의 자리를 분리할 원 숫자 (피제수)
        int divisor = 0;   // 제수
        
        // 각 자리의 숫자가 들어갈 수 있도록 자릿수 만큼의 int형 동적배열
        int[] eachNumber = new int[digit];
        
        // 원 숫자를 나눠가며 각 자릿수 분리
        for (int i = 0; i < digit; i++) {
            divisor       = (int) Math.pow(10, digit - i - 1);
            eachNumber[i] = number / divisor;
            number        = number % (eachNumber[i] * divisor);
        }
        
        assertThat(eachNumber[0]).isEqualTo(9);
        assertThat(eachNumber[1]).isEqualTo(5);
        assertThat(eachNumber[2]).isEqualTo(4);
        
    }
    
}
