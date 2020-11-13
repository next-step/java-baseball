package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("split 1,2 테스트")
    public void split12(){
        final String input = "1,2";

        String[] split = input.split(",");
        assertThat(split).containsExactly("1", "2");
    }

}
