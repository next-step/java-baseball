package baseball.domain;
import baseball.exception.InvalidateBallNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("BallNumber Test")
public class BallNumberTest {

    private void defaultBallNumberTest(BallNumber ballNumber) {
        assertTrue(ballNumber.getNumberByIndex(0) < 10 && ballNumber.getNumberByIndex(0) > 0);
        assertTrue(ballNumber.getNumberByIndex(1) < 10 && ballNumber.getNumberByIndex(1) > 0);
        assertTrue(ballNumber.getNumberByIndex(2) < 10 && ballNumber.getNumberByIndex(2) > 0);
        assertTrue(ballNumber.getNumberByIndex(0) != ballNumber.getNumberByIndex(1) );
        assertTrue(ballNumber.getNumberByIndex(0) != ballNumber.getNumberByIndex(2) );
        assertTrue(ballNumber.getNumberByIndex(1) != ballNumber.getNumberByIndex(2) );
    }

    @DisplayName("BallNumber Constructor Test")
    @RepeatedTest(10)
    public void initBallNumberTest() {
        BallNumber ballNumber = new BallNumber();
        defaultBallNumberTest(ballNumber);

    }

    @DisplayName("BallNumber Constructor(int ballNumbers) Test")
    @ParameterizedTest
    @ValueSource(ints = {123, 456, 789, 124, 462, 251, 812, 185})
    public void initBallNumberArgTest(int ballNumbers) {
        BallNumber ballNumber = new BallNumber(ballNumbers);
        defaultBallNumberTest(ballNumber);
        assertTrue(
                ballNumber.toString().equals("123") ||
                ballNumber.toString().equals("456") ||
                ballNumber.toString().equals("789") ||
                ballNumber.toString().equals("124") ||
                ballNumber.toString().equals("462") ||
                ballNumber.toString().equals("251") ||
                ballNumber.toString().equals("812") ||
                ballNumber.toString().equals("185")
        );
    }

    @DisplayName("BallNumber getByIndexNumber(int ballNumbers) Test")
    @ParameterizedTest
    @ValueSource(ints ={123, 456, 789})
    public void getByIndexNumberTest(int ballNumbers) {
        BallNumber ballNumber = new BallNumber(ballNumbers);
        defaultBallNumberTest(ballNumber);
        assertTrue(
                ballNumber.toString().equals("123") ||
                ballNumber.toString().equals("456") ||
                ballNumber.toString().equals("789")
        );

    }

    @DisplayName("BallNumber toString() Test")
    @ParameterizedTest
    @ValueSource(ints ={123, 456, 789})
    public void toStringTest(int ballNumbers) {
        BallNumber ballNumber = new BallNumber(ballNumbers);
        defaultBallNumberTest(ballNumber);
        assertTrue(
                ballNumber.toString().equals("123") ||
                        ballNumber.toString().equals("456") ||
                        ballNumber.toString().equals("789")
        );

    }

    @DisplayName("BallNumber Constuctor(int arg) Invalidate BallNumber SizeError Test")
    @ParameterizedTest
    @ValueSource(ints = {12, 1245, 12587, 5423, 92, 5716, 19245, 9157385})
    public void ballNumberInvalidateSizeErrorTest(int ballNumbers) {
        assertThrows(InvalidateBallNumberException.InvalidateBallNumberSizeError.class , () -> {
            BallNumber ballNumber = new BallNumber(ballNumbers);
        });
    }

    @DisplayName("BallNumber Constuctor(int arg) Invalidate BallNumber Value Test")
    @ParameterizedTest
    @ValueSource(ints = {102, 130, 901, 930})
    public void ballNumberInvalidateValueTest(int ballNumbers) {
        assertThrows(InvalidateBallNumberException.InvalidateBallNumberValueError.class , () -> {
            BallNumber ballNumber = new BallNumber(ballNumbers);
        });
    }
}
