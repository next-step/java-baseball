import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameResultPrinterTest {

    private BaseballGameResultPrinter baseballGameResultPrinter;

    @BeforeEach
    public void beforeSet() {
        baseballGameResultPrinter = new BaseballGameResultPrinter(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void printBaseballGameResultPrintNothing() {
        Assertions.assertEquals(baseballGameResultPrinter.baseballGameResultPrint(new int[] {0,0}), "낫싱");
    }

    @Test
    public void printBaseballGameResultPrintStrikes() {
        Assertions.assertEquals(baseballGameResultPrinter.baseballGameResultPrint(new int[] {1,0}), "1 스트라이크");
        Assertions.assertEquals(baseballGameResultPrinter.baseballGameResultPrint(new int[] {2,0}), "2 스트라이크");
        Assertions.assertEquals(baseballGameResultPrinter.baseballGameResultPrint(new int[] {3,0}), "3 스트라이크");
    }

    @Test
    public void printBaseballGameResultPrintBalls() {
        Assertions.assertEquals(baseballGameResultPrinter.baseballGameResultPrint(new int[] {0,1}), "1 볼");
        Assertions.assertEquals(baseballGameResultPrinter.baseballGameResultPrint(new int[] {0,2}), "2 볼");
        Assertions.assertEquals(baseballGameResultPrinter.baseballGameResultPrint(new int[] {0,3}), "3 볼");
    }
}
