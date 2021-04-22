package baseball.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShuffleTest {

    @DisplayName("Collections shuffle을 이용해 List를 섞을 수 있다")
    @Test
    void shuffleTest(){
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Collections.shuffle(list); // void
        assertThat(list).doesNotContainSequence("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

}
