package techcamp.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @DisplayName("생성된_숫자_리스트_검증")
    @Test
    public void validate_generated_numbers() {
        //Given
        Question game = new Question();

        //When
        List<Integer> numbers = game.getNumbers();

        //Then
        assertEquals(Config.NUMBERS_LENGTH, numbers.size(), "생성된 숫자 리스트의 사이즈는 설정된 값과 같아야 한다.");
        for (int number : numbers) {
            assertTrue(number >= Config.NUMBERS_MIN && number <= Config.NUMBERS_MAX, "생성된 숫자들은 설정된 값 범위 내이다.");
        }
    }
}