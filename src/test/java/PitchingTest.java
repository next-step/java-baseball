import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PitchingTest {
    Pitching pitching = new Pitching();
    BaseballNumber baseballNumber = new BaseballNumber();
    int[] baseball = baseballNumber.getBaseballNumber();

    @Test
    @DisplayName("스트라이크 1개가 나오는지 검사")
    void isStrikeTest() {
        int pass = 0;
        int[] pitches = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int pitch : pitches){
            if(pitching.isStrike(baseball, 0, pitch)){
                pass++;
            }
        }
        assertEquals(1, pass);
    }

    @Test
    @DisplayName("볼 2개가 나오는지 검사")
    void isBallTest() {
        int pass = 0;
        int[] pitches = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int pitch : pitches){
            if(pitching.isBall(baseball, 0, pitch)){
                pass++;
            }
        }
        assertEquals(2, pass);
    }

    @Test
    @DisplayName("3스트라이크 검사")
    void threeStrickTest() {
        String pitch = "";
        for(int ball : baseball){
            pitch += String.valueOf(ball);
        }

        PitchingResult pitchingResult = pitching.getPitchingResult(pitch,baseball);
        assertEquals(true, pitchingResult.isResult());
        assertEquals(3, pitchingResult.getStrike());
    }

    @Test
    @DisplayName("낫싱 검사")
    void isNothingTest() {
        int[] pitches = {1, 2, 3};

        PitchingResult pitchingResult = pitching.getPitchingResult("456",pitches);
        assertEquals(false, pitchingResult.isResult());
        assertEquals(false, pitchingResult.isNothing());
        assertEquals(0, pitchingResult.getStrike());
        assertEquals(0, pitchingResult.getBall());
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void oneStrikeoneBallTest() {
        int[] pitches = {1, 2, 3};

        PitchingResult pitchingResult = pitching.getPitchingResult("136",pitches);
        assertEquals(false, pitchingResult.isResult());
        assertEquals(false, pitchingResult.isNothing());
        assertEquals(1, pitchingResult.getStrike());
        assertEquals(1, pitchingResult.getBall());
    }

    @Test
    @DisplayName("1스트라이크 2볼")
    void oneStriketwoBallTest() {
        int[] pitches = {1, 2, 3};

        PitchingResult pitchingResult = pitching.getPitchingResult("321",pitches);
        assertEquals(false, pitchingResult.isResult());
        assertEquals(false, pitchingResult.isNothing());
        assertEquals(1, pitchingResult.getStrike());
        assertEquals(2, pitchingResult.getBall());
    }
}
