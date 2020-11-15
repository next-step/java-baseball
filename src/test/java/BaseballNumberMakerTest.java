import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberMakerTest {

    @Test
    @DisplayName("1부터 9까지 임의의 3자리 수 생성하기")
    public void makeRandomNumber() {
        BaseballNumberMaker numberMaker = new BaseballNumberMaker();
        for (int i = 0; i < numberMaker.NUMBER_SIZE; i++) {
            int randomNum = numberMaker.makeRandomNumber();
            assertThat(randomNum).isBetween(numberMaker.MIN_VALUE, numberMaker.MAX_VALUE);
        }
    }

    @Test
    @DisplayName("1부터 9까지 서로 다른 임의의 3자리 수 생성하기")
    public void makeNonDuplicateRandomNumber() {
        BaseballNumberMaker numberMaker = new BaseballNumberMaker();
        ArrayList<Integer> numbers = numberMaker.makeNonDuplicateRandomNumber();
        for (int randomNum : numbers) {
            assertThat(randomNum).isBetween(numberMaker.MIN_VALUE, numberMaker.MAX_VALUE);
        }
        assertThat(numbers).doesNotHaveDuplicates();
    }

}