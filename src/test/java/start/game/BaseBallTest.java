package start.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {
    private BaseBallImpl game;
    private int count = 0;
    private boolean isRange = true;
    private int number = 0;
    Set<Integer> digits;
    
    
    @BeforeEach
    public void setting() {
        game = new BaseBallImpl();
    }
    
    @Test
    @DisplayName(value = "1과 9사이의 숫자가 뽑혀야 한다.")
    public void getOneDigitNumberTest() {
        int[] numIndex = new int[9];
        int count = 0;
        
        while( count < 10000 ) {
            int number = game.getOneDigitNumber(1, 9);
            numIndex[number - 1] = 1;
            count++;
        }
        
        chekArrayHasNumber(numIndex);
       
    }
    
    @Test
    @DisplayName(value = "1과 9사이의 숫자 중  중복되지 않는 3자리의 수가 뽑혀야 한다.")
    public void getNonDuplicatedThreeDigitNumberTest() {
        count = 0;
        isRange = true;
        number = 0;
        digits = new HashSet<>(Arrays.asList(1, 2, 3));
        getTenThousandData();
        checkDuplicatedNumber();
        checkNumberRange();
    }
    
    private void chekArrayHasNumber( int[] numIndex ) {
        for( int data : numIndex ) {
            assertThat(data)
            .isEqualTo(1);
        }
    }
    
    private void getTenThousandData() {
        while( count < 10000 && isRange && digits.size() == 3 ) {
            number = game.getNonDuplicatedThreeDigitNumber(1, 9);
            digits = getDigit( number );
            isRange = checkMinMaxDigits( digits, 1, 9 );
            count++;
        }
    }
    
    private void checkDuplicatedNumber() {
        assertThat(digits.size())
            .isEqualTo(3);
    }
    
    private void checkNumberRange() {
        assertThat(isRange)
            .isEqualTo(true);
    }
    
    private boolean checkMinMaxDigits(Set<Integer> digits, int min, int max) {
        boolean result = false;
        for( int number : digits ) {
            result = checkMinMaxNumber( number, min, max );
        }
        return result;
    }
    

    private boolean checkMinMaxNumber( int number , int min, int max ) {
        return min <=number && number <= max;
    }

    private Set<Integer> getDigit( int number ){
        Set<Integer> result = new HashSet<>();
        for( int index = 2; index >= 0; index-- ) {
            int digit = number % 10;
            result.add(digit);
            number -= digit;
            number /= 10;
        }
        
        return result;
    }
    
}
