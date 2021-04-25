import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameStartMachineTest {


    @Test
    @DisplayName("게임 시작시 문자 입력의 경우 오류가 들어오는지 확인")
    public void gameStartStringVariableTest(){
        String name = "new";
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() ->{
              Integer.parseInt(name);
        }).withMessageMatching("For input string: \"new\"");
    }

    @Test
    @DisplayName("게임 시작시 2번 입력시 제대로 들어오는지 확인")
    public void gameStartIntegerVariableTest(){
       String name = "2";
       assertThat(Integer.parseInt(name.toString())).isEqualTo(2);
    }


}
