package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.util.GameStatus;

class BaseballNumberGeneratorTest {
	
    @DisplayName("3자리 숫자 생성 확인")
    @Test
    public void testCreateNumber() {
        Baseball numbers = BaseballNumberGenerator.CreateNumber();
        assertThat(numbers.getBaseballSize() == GameStatus.BALL_SIZE).isTrue();
    }
    
    @DisplayName("중복 여부 확인")
    @Test
    public void testDifferentEachOtherNumber() {
        Baseball numbers = BaseballNumberGenerator.CreateNumber();
        HashSet<Integer> differentSet = new HashSet<Integer>();		
        for(int i : numbers.getBaseball()) {
        	differentSet.add(i);
        }
        assertThat(differentSet.size() == GameStatus.BALL_SIZE).isTrue();
    }
 }
