import baseBall.util.CreateNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateNumberTest {

    private CreateNumber createNumber = new CreateNumber();

    @DisplayName("랜덤으로 숫자를 생성하는 테스트")
    @Test
    public void generateRandomNumberTest() {
        String randomNumber = createNumber.generateRandomNumber();
        assertThat(String.valueOf(randomNumber).matches("^[0-9]*$")).isTrue();
    }

    @DisplayName("랜덤으로 생성된 숫자의 총 길이가 3인지 테스트")
    @Test
    public void generateNumbersTest() {
        assertThat(createNumber.generateNumbers().length()).isEqualTo(3);
    }



}
