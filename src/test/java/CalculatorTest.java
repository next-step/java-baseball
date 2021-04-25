import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"123", "782"})
    @DisplayName("야구 볼 갯수 테스트")
    public void getBallCountTest(String user){
        String computer = "463";
        int checkCount = 0;
        for(int i=0;i<3;i++){
            if(computer.indexOf(user.charAt(i)) != -1) checkCount++;
        }
        assertThat(checkCount).isEqualTo(1);

    }

    @ParameterizedTest
    @CsvSource({"532", "245"})
    @DisplayName("야구 스트라이크 갯수 테스트")
    public void getStrikeCountTest(String user){
        String computer = "463";
        int checkCount = 0;
        for(int i=0;i<3;i++){
            if(computer.charAt(i) == user.charAt(i)) checkCount++;
        }
        assertThat(checkCount).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"123", "782"})
    @DisplayName("야구 낫싱 테스트")
    public void getNothingTest(String user){
        String computer = "564";
        int checkCount = 0;
        for(int i=0;i<3;i++){
            if(computer.charAt(i) == user.charAt(i)) checkCount++;
        }for(int i=0;i<3;i++){
            if(computer.indexOf(user.charAt(i)) != -1) checkCount++;
        }
        assertThat(checkCount).isEqualTo(0);

    }

    @ParameterizedTest
    @CsvSource({"123", "782"})
    @DisplayName("야구 전체 카운트 테스트")
    public void allCountTest(String user){
        String computer = "782";
        int strikeCount = 0;
        int ballCount = 0;
        for(int i=0;i<3;i++){
            if(computer.charAt(i) == user.charAt(i)) strikeCount++;
        }for(int i=0;i<3;i++){
            if(computer.indexOf(user.charAt(i)) != -1) ballCount++;
        }
        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(3);
    }
}
