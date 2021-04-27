import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseBallGameTest {

    static BaseBallGame baseBallGame = new BaseBallGame();

    @BeforeAll
    @Test
    void createNumberPoolTest(){
        baseBallGame.createNumberPool();
        Assertions.assertThat(baseBallGame.numberPool.size()).isEqualTo(9);
    }

    @DisplayName("숫자 풀 생성 로직 테스트")
    @Test
    void createTargetNumberTest(){
        String unit = baseBallGame.createTargetNumber(baseBallGame.numberPool.size());
        Assertions.assertThat(baseBallGame.numberPool.size()).isEqualTo(8);
    }

    @Test
    void makeTargetNumberListTest(){
        int digit = 3;
        baseBallGame.makeTargetNumberList(digit);
        Assertions.assertThat(baseBallGame.targetNumberList.size()).isEqualTo(digit);
    }

    @Test
    void checkAnswerTest(){
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.targetNumberList.add("3");
        baseBallGame.targetNumberList.add("6");
        baseBallGame.targetNumberList.add("7");

        String answer = "367";
        int result = baseBallGame.checkAnswer(answer);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void checkStrikeTest(){
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.targetNumberList.add("3");
        baseBallGame.targetNumberList.add("6");
        baseBallGame.targetNumberList.add("7");

        baseBallGame.checkStrike("3", 0);
        Assertions.assertThat(baseBallGame.checkResultModel.strike).isEqualTo(1);
    }

    @Test
    void checkBallTest(){
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.targetNumberList.add("3");
        baseBallGame.targetNumberList.add("6");
        baseBallGame.targetNumberList.add("7");

        baseBallGame.checkBall("7", 0);
        Assertions.assertThat(baseBallGame.checkResultModel.ball).isEqualTo(1);
    }

    @Test
    void makeResultMessageTest(){
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.targetNumberList.add("3");
        baseBallGame.targetNumberList.add("6");
        baseBallGame.targetNumberList.add("7");

        baseBallGame.checkAnswer("821");
        String message = baseBallGame.makeResultMessage(baseBallGame.checkResultModel);
        Assertions.assertThat(message).isEqualTo("포볼");
    }

    @Test
    void checkEndGameTest(){
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.targetNumberList.add("3");
        baseBallGame.targetNumberList.add("6");
        baseBallGame.targetNumberList.add("7");
        baseBallGame.checkAnswer("367");

        baseBallGame.checkEndGame(baseBallGame.checkResultModel);
        Assertions.assertThat(baseBallGame.isEnd).isEqualTo(1);
    }

    @Test
    void resetModelTest(){
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.checkResultModel.ball = 1;

        baseBallGame.resetModel(baseBallGame.checkResultModel);
        Assertions.assertThat(baseBallGame.checkResultModel.ball).isEqualTo(0);
    }

}
