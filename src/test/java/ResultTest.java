import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    public void 스트라잌테스트() {

        String inputVal = "321";
        String targetVal = "321";

        Result result = new Result();

        boolean isBall = result.isStrike(inputVal, targetVal, 2);

        assertThat(isBall).isTrue();
    }

    @Test
    public void 볼테스트() {

        String inputVal = "567";
        String targetVal = "586";

        Result result = new Result();

        boolean isBall = result.isBall(inputVal, targetVal, 1);

        assertThat(isBall).isTrue();
    }
}