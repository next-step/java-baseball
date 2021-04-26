package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitTest {

    private String inputText;

    @Test
    @DisplayName("1,2 -> 1과 2로 잘 분리되는지 테스트")
    void splitSuccessTest() {
        this.inputText = "1,2";
        Split split = new Split(inputText);
        split.checkValidText();
        assertThat(split.splitByComma()).contains("1", "2");
    }

    @Test
    @DisplayName("다른 문자열이 있을 때 검사 테스트")
    void validateOtherTextTest() {
        this.inputText = "1!,2";
        Split split = new Split(inputText);

        assertThatThrownBy(() -> {
            split.checkValidText();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자와 ,(comma)가 아닌 문자가 있습니다.");

    }


}
