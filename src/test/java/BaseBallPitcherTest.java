import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class BaseBallPitcherTest {
    @Test
    @DisplayName("랜덤 숫자 생성 후 길이 체크")
    void generateRandomNumber_LengthCheck() {
        Set<Integer> batterRandomNumber = new BaseBallPitcher().generateRandomNumber();
        assertEquals(batterRandomNumber.size(), PlayGame.RANDOM_NUMBER_LENGTH);
    }
}
