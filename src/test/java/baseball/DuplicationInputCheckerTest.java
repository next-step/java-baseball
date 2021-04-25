package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DuplicationInputCheckerTest {

    private DuplicationInputChecker duplicationInputChecker;

    @BeforeEach
    void setup(){
        this.duplicationInputChecker = new DuplicationInputChecker();
    }

    @ParameterizedTest
    @CsvSource(value = {"123443", "111", "121", "6898", "009", "685946"})
    @DisplayName("중복 입력값 검사 - 중복된 문자가 포함된 입력값의 경우 True를 리턴")
    void isDuplicated_duplicatedCharacterExists_ReturnsTrue(String duplicatedText){
        // when
        boolean result = this.duplicationInputChecker.isDuplicated(duplicatedText.toCharArray());

        // then
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"12345", "54321", "!@5^", "348", "234", "987", "0987", "6578", "&*2"})
    @DisplayName("중복 입력값 검사 - 중복된 문자가 포함되지 않은 입력값의 경우 False를 리턴")
    void isDuplicated_duplicatedCharacterNotExists_ReturnsFalse(String normalText){
        // when
        boolean result = this.duplicationInputChecker.isDuplicated(normalText.toCharArray());

        // then
        Assertions.assertThat(result).isFalse();
    }

}
