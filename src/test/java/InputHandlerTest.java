import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputHandlerTest {

    private ByteArrayInputStream testIn;

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    @DisplayName("인풋 검증 및 에러 발생 테스트")
    public void inputTest() {
        // case 1 : 정상 입력을 리스트로 변환하는 테스트
        String testString1 = "123";
        provideInput(testString1);
        InputHandler ih = new InputHandler();
        List<Integer> userRequest1 = ih.getUserRequest();
        assertThat(Arrays.asList(1, 2, 3)).isEqualTo(userRequest1);

        // case 2 : 숫자를 3개 이상 입력하면 발생하는 예외 테스트
        String testString2 = "1234";
        provideInput(testString2);
        InputHandler ih2 = new InputHandler();
        assertThrows(IllegalArgumentException.class, ih2::getUserRequest);

        // case 3 : 숫자가 아닌 문자가 섞여있으면 발생하는 예외 테스트
        String testString3 = "1 2 3";
        provideInput(testString3);
        InputHandler ih3 = new InputHandler();
        assertThrows(NumberFormatException.class, ih3::getUserRequest);

        // case 4 : 진행, 종료 이외의 명령 숫자 입력시 발생하는 예외 테스트
        String testString4 = "종료";
        provideInput(testString4);
        InputHandler ih4 = new InputHandler();
        assertThrows(IllegalArgumentException.class, ih4::getUserCommand);

        // case 4 : 진행, 종료 이외의 명령 숫자 입력시 발생하는 예외 테스트
        String testString5 = "1";
        provideInput(testString5);
        InputHandler ih5 = new InputHandler();
        Command userCommand = ih5.getUserCommand();
        assertThat(Command.CONTINUE).isEqualTo(userCommand);
    }

}
