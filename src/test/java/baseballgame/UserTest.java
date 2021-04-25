package baseballgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("선택한 숫자 개수가 다른 경우")
    void selectInvalidNumber() {
        //given
        String[] input = "1234".split("");
        //when
        //then
        assertNotEquals(Const.NUMBER_COUNT, input.length);
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 입력했을 경우")
    void inputString() {
        //given
        String[] inputs = "java".split("");
        //when
        for (String input : inputs) {
            //then
            assertFalse(Pattern.matches(Const.NUMBER_REGULAR_EXPRESSION, input));
        }
    }

    @Test
    @DisplayName("선택한 숫자를 리스트에 담기")
    void inputNumberToList() {
        //given
        //when
        String[] input = "1234".split("");
        //then
        assertNotEquals(Const.NUMBER_COUNT, input.length);
    }

    @Test
    @DisplayName("중복 된 숫자를 넣을 경우")
    void inputDuplicateNumber() {
        //given
        String[] inputs = "111".split("");
        List<Integer> numbers = new ArrayList<>();
        //when
        for (String input : inputs) {
            int number = Integer.parseInt(input);
            numbers.add(number);
            //then
            assertTrue(numbers.contains(Integer.parseInt(input)));
        }
    }
}