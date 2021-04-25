package techcamp.baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionTest {

    @DisplayName("생성된_숫자_리스트_검증")
    @RepeatedTest(value = 2, name = "{displayName}")
    public void validate_generated_numbers() {
        //Given
        Question question = new Question();
        Validation validation = new Validation();

        //When
        List<Integer> numbers = question.getNumbers();

        //Then
        assertEquals(Config.NUMBERS_LENGTH, numbers.size(), "생성된 숫자 리스트의 사이즈는 설정된 값과 같아야 한다.");
        for (int number : numbers) {
            assertTrue(number >= Config.NUMBERS_MIN && number <= Config.NUMBERS_MAX, "생성된 숫자들은 설정된 값 범위 내이다.");
        }
        assertTrue(validation.isDuplicatedList(question.getNumbers()), "입력된 값이 서로 다른 수여야 한다.");
    }
}