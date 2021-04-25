import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class ThreadLocalRandomNumberCreateTest {

    @Test
    void 생성되는_숫자의_범위는_1이상_9이하() {
        final int ONE = 1;
        final int NINE = 9;

        for (int i = 0; i < 1000; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(9) + 1;
            assertTrue(randomNumber >= ONE && randomNumber <= NINE);
        }
    }
}
