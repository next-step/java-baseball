package baseball.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ArraysAsListTest {

    @DisplayName("Arrays asList로 만들어진 List에서 add, remove 메서드를 호출하면 UnsupportedOperationException 예외가 발생한다")
    @Test
    void asListTest() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        assertThatThrownBy(() -> list.add("10"))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> list.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("new ArrayList로 감싸면 add, remove 메서드를 사용할 수 있다")
    @Test
    void arrayListTest() {
        List<String> list = new ArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        list.add("10");
        assertThat(list).containsExactly("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        list.remove(0);
        assertThat(list).containsExactly("2", "3", "4", "5", "6", "7", "8", "9", "10");
    }

}
