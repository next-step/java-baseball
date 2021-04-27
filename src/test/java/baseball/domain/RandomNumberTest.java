package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberTest {

    @Test
    @DisplayName("Random 숫자가 3개가 제대로 나오는지 확인")
    void createRandomTest(){
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.createRandomNumber().size()).isEqualTo(3);
    }

}
