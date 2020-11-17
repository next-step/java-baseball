package game.system;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    private int key;

    RefereeTest(){
        this.key = 123;
    }

    @Test
    public void meetsAllDigitAndPosition_Then_StrikeOut(){
        Referee referee = new Referee(key);
        int battingDigit = 123;
        boolean result = referee.isStrikeOut(battingDigit);

        assertEquals(true, result);
    }

    @Test
    public void inputDigit_1_Then_ContinueGame(){
        Referee referee = new Referee(key);
        String userInput = "1";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        referee.askContinue();

        assertEquals(false, referee.isLastGame());
    }

    @Test
    public void inputDigit_2_Then_LastGame(){
        Referee referee = new Referee(key);
        String userInput = "2";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        referee.askContinue();

        assertEquals(true, referee.isLastGame());
    }



}