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
}
