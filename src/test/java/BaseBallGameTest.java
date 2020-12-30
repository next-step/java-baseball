import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import java.util.HashSet;

class BaseBallGameTest {

    BaseBallGame myBaseBallGame = new BaseBallGame();

    @BeforeEach
    void setup(){
       // this.myBaseBallGame = new BaseBallGame();
    }

    @Test
    public void testmakeTagetNumber(){
        int result = myBaseBallGame.makeTagetNumber();
        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {125,456,872,465})
    public void testCheckInputNumber1(int number){
        assertThat(myBaseBallGame.checkInputNumber(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1255,202,7,65235})
    public void testCheckInputNumber2(int number){
        assertThat(myBaseBallGame.checkInputNumber(number)).isFalse();
    }

    @Test
    public void testStrikeCount(){
        myBaseBallGame.setTargetNumber(125);
        assertThat(myBaseBallGame.strikeCount(123)).isEqualTo(2);
        assertThat(myBaseBallGame.strikeCount(356)).isEqualTo(0);
        assertThat(myBaseBallGame.strikeCount(395)).isEqualTo(1);
    }

    @Test
    public void testBallCount(){
        myBaseBallGame.setTargetNumber(125);
        assertThat(myBaseBallGame.ballCount(152, myBaseBallGame.strikeCount(152))).isEqualTo(2);
        assertThat(myBaseBallGame.ballCount(815, myBaseBallGame.strikeCount(815))).isEqualTo(1);
    }

}
