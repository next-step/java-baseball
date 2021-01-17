import baseball.Computer;
import baseball.util.NumberUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {

        @Test
        public void newNumberTest() {
            Computer cp = new Computer();

            int answer = cp.getAnswer();
            assertThat(answer).isGreaterThanOrEqualTo(123);
            assertThat(answer).isLessThanOrEqualTo(987);
            assertThat(NumberUtil.getHundredNumber(answer)).isNotEqualTo(NumberUtil.getTenNumber(answer));
            assertThat(NumberUtil.getTenNumber(answer)).isNotEqualTo(NumberUtil.getOneNumber(answer));
            assertThat(NumberUtil.getOneNumber(answer)).isNotEqualTo(NumberUtil.getHundredNumber(answer));
        }

}
