import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GuessNumberTest {

    private static BaseBallDTO dto;
    private static GuessNumber guessNumber;

    @BeforeAll
    static  void  setup(){
        dto = new BaseBallDTO();
        guessNumber = new GuessNumber();
    }

    public void resetBallCount(BaseBallDTO dto){
        dto.setCountOfBall(0);
        dto.setCountOfStrike(0);
    }

    @Test
    public void generateNumber(){
        List<String> enemyList = Arrays.asList("4","8","1");
        dto.setEnemyNumbers(enemyList);
        List<String> myList = Arrays.asList("4","9","6");
        System.out.println("입력값-> "+myList);
        dto.setInputNumbers(myList);
        guessNumber.doGuessNumber(dto);
        Assertions.assertEquals(0,dto.getCountOfBall());
        Assertions.assertEquals(1,dto.getCountOfStrike());
        resetBallCount(dto);

        myList = Arrays.asList("4","8","1");
        System.out.println("입력값-> "+myList);
        dto.setInputNumbers(myList);
        guessNumber.doGuessNumber(dto);
        Assertions.assertEquals(0,dto.getCountOfBall());
        Assertions.assertEquals(3,dto.getCountOfStrike());
        resetBallCount(dto);


        myList = Arrays.asList("6","9","4");
        System.out.println("입력값-> "+myList);
        dto.setInputNumbers(myList);
        guessNumber.doGuessNumber(dto);
        Assertions.assertEquals(1,dto.getCountOfBall());
        Assertions.assertEquals(0,dto.getCountOfStrike());
        resetBallCount(dto);

        myList = Arrays.asList("1","4","8");
        System.out.println("입력값-> "+myList);
        dto.setInputNumbers(myList);
        guessNumber.doGuessNumber(dto);
        Assertions.assertEquals(3,dto.getCountOfBall());
        Assertions.assertEquals(0,dto.getCountOfStrike());
        resetBallCount(dto);

        myList = Arrays.asList("5","2","3");
        System.out.println("입력값-> "+myList);
        dto.setInputNumbers(myList);
        guessNumber.doGuessNumber(dto);
        Assertions.assertEquals(0,dto.getCountOfBall());
        Assertions.assertEquals(0,dto.getCountOfStrike());
        resetBallCount(dto);

    }

}