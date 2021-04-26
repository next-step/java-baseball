import exception.NotNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questionnumber.Computer;
import questionnumber.QuestionNumber;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StarterTest {
    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame(new Computer(new QuestionNumber()));
    }

    @Test
    void checkNotNumberException() {
        String inputString = "abc";

        assertThrows(NotNumberException.class, () ->{
            Starter.isNumberValidation(inputString);
        });
    }
}
