package game.system;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private int [] digits;

    RefereeTest(){
        this.digits = new int[]{1, 2, 3};
    }

    @Test
    public void meetsAllDigitAndPosition_Then_StrikeOut(){
        Referee referee = new Referee(digits);
        String userInput = "123";
        referee.judgeBatting(userInput);
        boolean result = referee.isStrikeOut();

        assertEquals(true, result);
    }

    @Test
    public void inputDigit_1_Then_ContinueGame(){
        Referee referee = new Referee(digits);
        String userInput = "1";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        boolean result = referee.askFinish();
        System.setIn(System.in);

        assertEquals(false, result);
    }

    @Test
    public void inputDigit_2_Then_LastGame(){
        Referee referee = new Referee(digits);
        String userInput = "2";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        boolean result = referee.askFinish();
        System.setIn(System.in);

        assertEquals(true, result);
    }

    @Test
    public void meetsNothing_Then_Nothing(){
        setUp();
        Referee referee = new Referee(digits);
        String userInput = "456";
        referee.judgeBatting(userInput);
        String result = referee.createHintMessage();

        assertEquals("낫싱", result);
    }

    @Test
    public void meets2StrikeCase_Then_2Strike(){
        setUp();
        Referee referee = new Referee(digits);
        String userInput = "125";
        referee.judgeBatting(userInput);
        String result = referee.createHintMessage();

        assertEquals("2스트라이크", result);
    }

    @Test
    public void meetsStrikeAndBall_Then_1Strike1Ball(){
        setUp();
        Referee referee = new Referee(digits);
        String userInput = "138";
        referee.judgeBatting(userInput);
        String result = referee.createHintMessage();

        assertEquals("1스트라이크 1볼", result);
    }
}