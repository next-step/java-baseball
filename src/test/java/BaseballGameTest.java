import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @Test
    void stringConverterToIntegerList() {
        // given
        String presentationNumberWithString = "123";
        List<Integer> presentationNumber = new ArrayList<>();

        // when
        String [] presentationNumberWithStringArray = presentationNumberWithString.split("");

        for (int i=0; i < presentationNumberWithStringArray.length; i++) {
            presentationNumber.add(Integer.valueOf(presentationNumberWithStringArray[i]));
        }

        // then
        assertThat(presentationNumber.get(0)).isEqualTo(1);
        assertThat(presentationNumber.get(1)).isEqualTo(2);
        assertThat(presentationNumber.get(2)).isEqualTo(3);
    }
}
