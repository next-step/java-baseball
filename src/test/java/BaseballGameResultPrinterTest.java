import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class BaseballGameResultPrinterTest {

    private BaseballGameResultPrinter printer;

    @Before
    public void setUp() throws Exception {
        printer = new BaseballGameResultPrinter();
    }

    @Test
    public void printerConvertGameResultNothing(){
        BaseballGameResultPrinter printer = new BaseballGameResultPrinter();
        assertEquals(printer.convertBaseballGameResult(new int[]{0, 0}), "낫싱");
    }

    @Test
    public void printerConvertGameResultStrikes(){
        assertEquals(printer.convertBaseballGameResult(new int[]{1, 0}), "1 스트라이크");
        assertEquals(printer.convertBaseballGameResult(new int[]{2, 0}), "2 스트라이크");
        assertEquals(printer.convertBaseballGameResult(new int[]{3, 0}), "3 스트라이크");
    }

}
