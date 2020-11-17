import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeNumberTest {

    @Test
    public void 숫자생성된다() {

        MakeNumber makeNumber = new MakeNumber();

        String targetNumber = makeNumber.makeRandomNumber(3);

        System.out.println(targetNumber);

    }

    @Test
    public void 숫자추출() {
        String inputVal = "1,2,3";
        String expectVal = "123";

        MakeNumber makeNumber = new MakeNumber();

        String resultVal = makeNumber.extractNumber(inputVal);

        assertThat(resultVal).isEqualTo(expectVal);
    }
}