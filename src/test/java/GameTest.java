import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameTest {

    @Test
    @DisplayName("사용자가 세자리 이상의 숫자를 입력할 경우")
    public void gameStringOverThreeDigits(){
      String numberTest = "1500";
      assertThat(numberTest.length()).isNotEqualTo(3);
    }

    @Test
    @DisplayName("사용자가 문자를 입력할 경우")
    public void gameStringVariableTest(){
        String name = "사용자 테스트";
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() ->{
                    Integer.parseInt(name);
                }).withMessageMatching("For input string: \"사용자 테스트\"");
    }

}
