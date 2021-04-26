import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringStudyTest {
    @Test
    @DisplayName("1,2 확인")
    void seperateOneTwoTest(){
        StringStudy stringStudy = new StringStudy("1,2");
        String[] result = stringStudy.seperateOneTwo(stringStudy.getInput());
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("1, split 확인")
    void seperateOneTest(){
        StringStudy stringStudy = new StringStudy("1,");
        String[] result = stringStudy.seperateOneTwo(stringStudy.getInput());
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring ()제거")
    void substringTest(){
        StringStudy stringStudy = new StringStudy("(1,2)");
        String result = stringStudy.substringPreEnd(stringStudy.getInput());
        assertEquals("1,2", result);
    }

    @Test
    @DisplayName("인덱스의 범위가 벗어난곳 익셉션 메시지 표현")
    void charAtABCTest(){
        StringStudy stringStudy = new StringStudy("ABC");
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(()->{
            Character result = stringStudy.charAtABC(stringStudy.getInput(),4);
        }).withMessageMatching("index는 2까지 입력 가능합니다.");


    }
}
