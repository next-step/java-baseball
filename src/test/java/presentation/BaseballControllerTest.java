package presentation;

import com.study.application.BaseballService;
import com.study.application.model.InputModel;
import com.study.domain.BaseballGame;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Jaedoo Lee
 */
class BaseballControllerTest {

    private BaseballService game;

    public BaseballControllerTest() {
        this.game = new BaseballService();
    }

    @Test
    public void 게임_턴_넘기기_테스트() throws IOException {
        //given
        int inputNumber = 123;
        BaseballGame number = new BaseballGame();
        InputModel input = new InputModel(inputNumber, new BufferedReader(new InputStreamReader(System.in)));

        //when
        boolean isContinue = game.isContinue(number, input);

        //then
        assertTrue(isContinue);
    }

}
