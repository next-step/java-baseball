import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

public class NumberCheckerTest {

    private NumberChecker numberChecker;

    @BeforeEach
    public void setUp() {
        RandomNumber mockRandomNumber = mock(RandomNumber.class);
        when(mockRandomNumber.get(0)).thenReturn("1");
        when(mockRandomNumber.get(1)).thenReturn("2");
        when(mockRandomNumber.get(2)).thenReturn("3");
        when(mockRandomNumber.contain("1")).thenReturn(true);
        when(mockRandomNumber.contain("2")).thenReturn(true);
        when(mockRandomNumber.contain("3")).thenReturn(true);
        numberChecker = new NumberChecker(3, mockRandomNumber);
    }

    @Test
    public void testCorrectCheck() {
        assertThat(numberChecker.check("123").correct()).isTrue();
        assertThat(numberChecker.check("123").toString()).isEqualTo("모두 맞추셨습니다");
    }

    @Test
    public void testWrongCheck() {
        assertThat(numberChecker.check("456").correct()).isFalse();
        assertThat(numberChecker.check("456").toString()).isEqualTo("아무것도 맞추지 못하셧습니다");
    }

    @Test
    public void testMixedCase() {
        assertThat(numberChecker.check("239").correct()).isFalse();
        assertThat(numberChecker.check("239").toString()).isEqualTo("2 볼 ");

        assertThat(numberChecker.check("124").correct()).isFalse();
        assertThat(numberChecker.check("124").toString()).isEqualTo("2 스트라이크 ");

        assertThat(numberChecker.check("132").correct()).isFalse();
        assertThat(numberChecker.check("132").toString()).isEqualTo("1 스트라이크 2 볼 ");

        assertThat(numberChecker.check("321").correct()).isFalse();
        assertThat(numberChecker.check("321").toString()).isEqualTo("2 볼 1 스트라이크 ");
    }

}
