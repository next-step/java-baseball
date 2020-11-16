package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    private final BaseballGame baseballGame = new BaseballGame();

    @Test
    @DisplayName("1부터 9까지 3자리 랜덤한 숫자 생성 size 확인")
    void generateSet() {
        Set<Integer> numbers = baseballGame.getGenerateNumber();
        String[] numberArray = baseballGame.getGenerateNumberArray();

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numberArray.length).isEqualTo(3);
    }
}