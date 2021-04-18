import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameLogicTest {

    @Test
    public void strikeLogic() throws Exception{
        //given
        Integer random = 123;
        Integer userInput = 123;
        GameLogic gameLogic = new GameLogic(random,userInput);
        String answer;
        //when
        answer = gameLogic.getAnswer();
        //then
        org.junit.jupiter.api.Assertions.assertEquals(answer, "3스트라이크");
    }

    @Test
    public void ballLogic() throws Exception{
        //given
        Integer random = 123;
        Integer userInput = 231;
        GameLogic gameLogic = new GameLogic(random,userInput);
        String answer;
        //when
        answer = gameLogic.getAnswer();
        //then
        org.junit.jupiter.api.Assertions.assertEquals(answer, "3볼");
    }

    @Test
    public void notingLogic() throws Exception{
        //given
        Integer random = 123;
        Integer userInput = 456;
        GameLogic gameLogic = new GameLogic(random,userInput);
        String answer;
        //when
        answer = gameLogic.getAnswer();
        //then
        org.junit.jupiter.api.Assertions.assertEquals(answer, "낫싱");
    }
}
