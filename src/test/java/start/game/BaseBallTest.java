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
    @DisplayName(value = "입력받은 수를 Strig 배열로 반환한다.")
    private void castNumberToStringArraysTest() {
        String[] digits = game.castNumberToStringArrays(123);
        assertThat(digits).containsExactly("1", "2","3");
    }
    
    @Test
    @DisplayName(value = "퀴즈 숫자와 사용자가 입력한 숫자를 비교하여 볼 수를 확인한다.")
    public void getBallCountFromTest() {
        String[] quizNumberDigts = game.castNumberToStringArrays(123);
        testQuizeAndInputBall(quizNumberDigts, 123, 0);
        testQuizeAndInputBall(quizNumberDigts, 415, 1);
        testQuizeAndInputBall(quizNumberDigts, 256, 1);
        testQuizeAndInputBall(quizNumberDigts, 347, 1);
        testQuizeAndInputBall(quizNumberDigts, 317, 2);
        testQuizeAndInputBall(quizNumberDigts, 217, 2);
        testQuizeAndInputBall(quizNumberDigts, 251, 2);
        testQuizeAndInputBall(quizNumberDigts, 312, 3);
    }
    
    @Test
    @DisplayName(value = "userIndex 가지고 해당 index에 해당하는 user값이 ball 일경우 1 아닐경우 0을 반환한다.")
    public void ballCountWithUserIndexTest() {
        String[] userNumberDigts = game.castNumberToStringArrays(345);
        String[] quizNumberDigts = game.castNumberToStringArrays(123);
        String[] quizNumberDigts2 = game.castNumberToStringArrays(423);
        assertThat(game.ballCountWithUserIndex( quizNumberDigts, userNumberDigts, 0 )).isEqualTo(1);
        assertThat(game.ballCountWithUserIndex( quizNumberDigts, userNumberDigts, 1 )).isEqualTo(0);
        assertThat(game.ballCountWithUserIndex( quizNumberDigts, userNumberDigts, 2 )).isEqualTo(0);
        assertThat(game.ballCountWithUserIndex( quizNumberDigts2, userNumberDigts, 0 )).isEqualTo(1);
        assertThat(game.ballCountWithUserIndex( quizNumberDigts2, userNumberDigts, 1 )).isEqualTo(1);
        assertThat(game.ballCountWithUserIndex( quizNumberDigts2, userNumberDigts, 2 )).isEqualTo(0);
    }
    
    @Test
    @DisplayName(value = "userIndex, quizIndex 가지고 둘이 다를때 서로 값을 비교한다.")
    public void ballCountWithUserIndexAndQuizIndexTest() {
        String[] userNumberDigts = game.castNumberToStringArrays(345);
        String[] quizNumberDigts = game.castNumberToStringArrays(423);
        assertThat(game.ballCountWithUserIndexAndQuizIndex(quizNumberDigts, userNumberDigts, 0, 0)).isEqualTo(0);
        assertThat(game.ballCountWithUserIndexAndQuizIndex(quizNumberDigts, userNumberDigts, 0, 1)).isEqualTo(0);
        assertThat(game.ballCountWithUserIndexAndQuizIndex(quizNumberDigts, userNumberDigts, 0, 2)).isEqualTo(1);
        assertThat(game.ballCountWithUserIndexAndQuizIndex(quizNumberDigts, userNumberDigts, 1, 0)).isEqualTo(1);
        assertThat(game.ballCountWithUserIndexAndQuizIndex(quizNumberDigts, userNumberDigts, 1, 1)).isEqualTo(0);
        assertThat(game.ballCountWithUserIndexAndQuizIndex(quizNumberDigts, userNumberDigts, 1, 2)).isEqualTo(0);
    }
    
    @Test
    @DisplayName(value = "퀴즈 숫자와 사용자가 입력한 숫자를 비교하여 스트라이크 수를 확인한다.")
    public void getStrikeCountFromTest() {
        String[] quizNumberDigts = game.castNumberToStringArrays(123);
        testQuizeAndInputStrike(quizNumberDigts, 123, 3);
        testQuizeAndInputStrike(quizNumberDigts, 124, 2);
        testQuizeAndInputStrike(quizNumberDigts, 143, 2);
        testQuizeAndInputStrike(quizNumberDigts, 523, 2);
        testQuizeAndInputStrike(quizNumberDigts, 453, 1);
        testQuizeAndInputStrike(quizNumberDigts, 425, 1);
        testQuizeAndInputStrike(quizNumberDigts, 157, 1);
        testQuizeAndInputStrike(quizNumberDigts, 789, 0);
    }
    
    @Test
    @DisplayName(value = "입력 받은 문자열을 비교하여 같으면 1을 다르면 0을 반환한다.")
    public void numberCompareTest() {
        assertThat(game.numberCompare("1","2")).isEqualTo(0);
        assertThat(game.numberCompare("1","1")).isEqualTo(1);
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
    
    private void testQuizeAndInputBall( String[] quizNumberDigts, int inputNumber, int expected ) {
        assertThat(game.getBallCountFrom(quizNumberDigts, game.castNumberToStringArrays(inputNumber))).isEqualTo(expected);
    }
    
    private void testQuizeAndInputStrike( String[] quizNumberDigts, int inputNumber, int expected ) {
        assertThat(game.getStrikeCountFrom(quizNumberDigts, game.castNumberToStringArrays(inputNumber))).isEqualTo(expected);
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
