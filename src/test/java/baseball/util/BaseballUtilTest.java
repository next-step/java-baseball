package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballUtilTest {

    @DisplayName("랜덤 생성된 숫자가 세자리 숫자인지 테스트")
    @Test
    void makeRandomNumTest() {
        String random = BaseballUtil.makeRandomNum();
        assertThat(random.length()).isEqualTo(3);
    }

    @DisplayName("랜덤 생성되어 넘어온 string이 중복없는 수인지 확인하는 함수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123:true","122:false","111:false"},delimiter = ':')
    void isValidNumber(String random, boolean expected) {
        assertThat(BaseballUtil.isValidNumber(random)).isEqualTo(expected);
    }
}