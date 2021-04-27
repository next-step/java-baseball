import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaBaseballGameTest {

    private JavaBaseballGame javaBaseballGame = new JavaBaseballGame();

    @Test
    void getStrike() {
        assertEquals(javaBaseballGame.getStrike("1","1"),1);
    }

    @Test
    void getBall() {
        List<String> xString = Arrays.asList("1","2","3");
        String n = "1";
        int index = 2;

        assertNotEquals(javaBaseballGame.getBall(xString,n,index),0);
    }

    @Test
    void createRandomNumber() {
        int randomNumber = javaBaseballGame.createRandomNumber();
        assertEquals(javaBaseballGame.convertStringToInt(randomNumber).size(),3);
    }

    @Test
    void printSentence(){

        assertEquals(javaBaseballGame.printSentence(123,123),"3 스트라이크");
    }


}