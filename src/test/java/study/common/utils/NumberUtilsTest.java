package study.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @Test
    @DisplayName("숫자 생성이 규칙에 맞게 되었는지 테스트")
    public void 숫자_범위_테스트() {

        NumberUtils numberUtils = new NumberUtils();

        int testNumber = numberUtils.nextInt();

        assertThat(testNumber)
                .isNotNull()
                .isBetween(123, 987);

    }


    @DisplayName("중복 되는 숫자로 구성시 false 반환 테스트")
    @ParameterizedTest
    @CsvSource({
            "333",
            "332"
    })
    public void 입력숫자_구성_중복_확인(int input) {

        NumberUtils numberUtils = new NumberUtils();

        assertThat(numberUtils.checkDuplicateNumber(input)).isEqualTo(false);

    }

}