package utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilTest {

    @Test
    @DisplayName("값 입력 테스트")
    @Disabled
    public void inputTest() {
        // given
        String expected = "123";
        InputStream in = new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // when
        String input = InputUtil.input();

        // then
        assertThat(input).isEqualTo(expected);
    }

    @Test
    @DisplayName("String -> List<Integer> 변환 테스트")
    public void transferStringToIntegerListTest() {
        // given
        String input = "123";
        List<Integer> expected = Arrays.asList(1, 2, 3);

        // when
        List<Integer> integers = InputUtil.transferStringToIntegerList(input);

        // then
        assertThat(integers).isEqualTo(expected);
    }
}