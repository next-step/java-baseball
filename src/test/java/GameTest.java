import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("입력받은 2 숫자의 자릿수가 같은 스트라이크 count를 계산하여 맞는지 검사한다")
    void strikeTest(){
        String computerNum = "246";

        String inputNum1 = "246";
        Game game = new Game();
        assertThat(game.strike(computerNum, inputNum1)).isEqualTo(3);

        String inputNum2 = "285";
        assertThat(game.strike(computerNum, inputNum2)).isEqualTo(1);
    }


}
