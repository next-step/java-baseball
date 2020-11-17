package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {


    @DisplayName("사용자 입력값 3자리수 체크")
    @Test
    public void inputNumberCheck(){


        boolean inputCheck = true;

        String[] userInput = {"1"};

        Input input = new Input();

        inputCheck  = input.validatorCheckNumber(userInput);

        assertThat(inputCheck).isFalse();


    }

    @DisplayName("사용자 입력된 값이 3자리 이상일 경우")
    @Test
    public void overNumberCheck(){


        boolean inputCheck = true;

        String[] userInput = {"1","3","5","6"};

        Input input = new Input();

        inputCheck  = input.validatorCheckNumber(userInput);

        assertThat(inputCheck).isFalse();


    }


}
