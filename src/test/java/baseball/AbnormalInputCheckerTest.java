package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AbnormalInputCheckerTest {

    private AbnormalInputChecker abnormalInputChecker;

    @BeforeEach
    void setup(){
        this.abnormalInputChecker = new AbnormalInputChecker();
    }

    @ParameterizedTest
    @CsvSource(value={"32!", "!!2", "%43", "$%abc", "-=087"})
    @DisplayName("비정상 입력값 검사 - 비정상적인 문자가 포함된 입력값의 경우 True를 리턴")
    void isAbnormal_abnormalCharacterExists_ReturnsTrue(String abnormalText){
        // when
        boolean result = this.abnormalInputChecker.isAbnormal(abnormalText.toCharArray());

        // then
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"123", "523", "675533", "4321", "9725", "876"})
    @DisplayName("비정상 입력값 검사 - 비정상적인 문자가 포함되지 않은 입력값의 경우 False를 리턴")
    void isAbnormal_abnormalCharacterNotExists_ReturnsFalse(String normalText){
        // when
        boolean result = this.abnormalInputChecker.isAbnormal(normalText.toCharArray());

        // then
        Assertions.assertThat(result).isFalse();
    }
}
