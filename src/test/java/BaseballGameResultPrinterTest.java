import org.junit.jupiter.api.Test;

public class BaseballGameResultPrinterTest {

    private BaseballGameResultPrinter baseballGameResultPrinter;

    @Test
    public void beforeSet() {
        baseballGameResultPrinter = new BaseballGameResultPrinter(BaseballGame.DEFAULT_LEN);
    }
}
