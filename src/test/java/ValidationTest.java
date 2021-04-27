import domain.Validation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ValidationTest {
    @Test
    public void Validation() throws Exception {
        List numbers1 = Arrays.asList(1, 2, 3);
        new Validation(numbers1);

        //List numbers2 = Arrays.asList(1, 2, 2);
        //new Validation(numbers2);

        List numbers3 = Arrays.asList(1, 2, 3, 4);
        new Validation(numbers3);

    }
}
