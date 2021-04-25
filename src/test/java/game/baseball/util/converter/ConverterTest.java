package game.baseball.util.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    @DisplayName("String 배열을 Integer 리스트로 변환")
    public void convertStringArrayToIntegerList(){
        Converter converter = new Converter();
        String[] stringArray = "123".split("");
        ArrayList<Integer> compareList = new ArrayList<>();
        compareList.add(1);
        compareList.add(2);
        compareList.add(3);
        ArrayList<Integer> list = converter.convertStringArrayToIntegerList(stringArray);

        assertThat(list).isEqualTo(compareList);

    }
}
