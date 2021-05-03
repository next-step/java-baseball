package start.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {
    private Ball com;
    
    @BeforeEach
    void setUP() {
        com = new Ball(1, 4);
    }
    
    @Test
    @DisplayName("strike 테스트")
    public void strikeTest(){
        assertThat( com.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }
    
    @Test
    @DisplayName("ball 테스트")
    public void ballTest(){
        assertThat( com.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }
    
    @Test
    @DisplayName("noting 테스트")
    public void nothingTest(){
        assertThat( com.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
    }
}
