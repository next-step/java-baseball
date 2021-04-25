package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseBallUtilTest {

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리 수 생성 : " +
            "임의의수생성기능_개수")
    @Test
    public void 임의의수생성기능_개수(){

        int MAX_SIZE = 3;
        List<Integer> numbers = new ArrayList<>(MAX_SIZE);
        while (numbers.size() < MAX_SIZE) {
            setRandomNumber(numbers);
        }

        assertThat(numbers).hasSize(3);
    }
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리 수 생성 : " +
            "임의의수생성기능_숫자크기")
    @Test
    public void 임의의수생성기능_숫자크기(){

        int MAX_SIZE = 3;
        List<Integer> numbers = new ArrayList<>(MAX_SIZE);
        while (numbers.size() < MAX_SIZE) {
            setRandomNumber(numbers);
        }

        for(int i =0; i < numbers.size(); i++){
            assertTrue(numbers.get(i) > 0 && numbers.get(i) < 10, i + "번째 idx 값이 \""+ numbers.get(i)+"\" 1~9 사이가 아님");
        }
    }

    /*
        랜덤 숫자 생성 기능.
     */
    private void setRandomNumber(List<Integer> numbers) {
        int MIN = 1;
        int MAX = 10;
        int random = ThreadLocalRandom.current().nextInt(MIN, MAX);

        if (!numbers.contains(random)) {
            numbers.add(random);
        }
    }

}
