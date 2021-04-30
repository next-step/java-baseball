package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitStudyTest {

    @Test
    @DisplayName("Split test")
    public void StringTest() {
        String text1 = "1,2";
        String[] split1 = text1.split(",");

        assertThat(split1.length).isEqualTo(2);
        assertThat(split1).containsExactly("1","2");
        assertThat(split1).doesNotContain("1,2");

        String text2 = "1";
        String[] split2 = text2.split(",");

        assertThat(split2.length).isEqualTo(1);
        assertThat(split2).contains("1");
        assertThat(split2).doesNotContain(",");
    }

    @Test
    @DisplayName("remove bracket Test")
    public void removeBracketTest() {
        assertThat(StringStudy.removeBracket("(1,2)")).isEqualTo("1,2");
        assertThatIllegalArgumentException().isThrownBy(() -> StringStudy.removeBracket(null));
        assertThatIllegalArgumentException().isThrownBy(() -> StringStudy.removeBracket(""));
        assertThatIllegalArgumentException().isThrownBy(() -> StringStudy.removeBracket("1,2)"));
        assertThatIllegalArgumentException().isThrownBy(() -> StringStudy.removeBracket("1,2"));
//        assertThatIOException().isThrownBy(() -> StringStudy.removeBracket("1,2"));
    }

    @Test
    @DisplayName("assertAll Test")
    public void assertAllTest() {
        assertAll (
                () -> assertThat(true).isEqualTo(true),
                () -> assertThat(true).isEqualTo(false),
                () -> assertThat(true).isEqualTo(true)
        );
    }
}
