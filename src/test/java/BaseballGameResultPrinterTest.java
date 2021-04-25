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

    @Test
    public void printerConvertGameResultBalls(){
        assertEquals(printer.convertBaseballGameResult(new int[]{0, 1}), "1 볼");
        assertEquals(printer.convertBaseballGameResult(new int[]{0, 2}), "2 볼");
        assertEquals(printer.convertBaseballGameResult(new int[]{0, 3}), "3 볼");
    }

    @Test
    public void printerConvertGameResultStrikesAndBalls(){
        //2, 1 은 불가능하다
        assertEquals(printer.convertBaseballGameResult(new int[]{1, 2}), "1 스트라이크 2 볼");
        assertEquals(printer.convertBaseballGameResult(new int[]{1, 1}), "1 스트라이크 1 볼");
    }

}
