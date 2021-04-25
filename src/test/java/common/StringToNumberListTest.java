package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.Numbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToNumberListTest {

    @DisplayName("문자열로 된 숫자들을 String List로 변환 ")
    @Test
    void should_return_lotto_when_transform() {
        // when
        final Numbers numbers = StringToNumberList.transform("123");

        // then
        assertThat(numbers).isNotNull();
    }

}