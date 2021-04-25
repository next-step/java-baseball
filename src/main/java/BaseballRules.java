import java.security.SecureRandom;
import java.util.Random;

public class BaseballRules {

    protected String[] createRandomNumbers(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(Message.LESS_THAN_1.getText());
        }

        Random random = new SecureRandom();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            result[i] = String.valueOf(random.nextInt(10));
        }

        return result;
    }
}
