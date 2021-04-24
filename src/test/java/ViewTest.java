import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import number.Numbers;

public class ViewTest {

	@Test
	@DisplayName("사용자가 입력한 숫자가 나와야 한다.")
	public void inputNumbersTest() {
		// given
		String userInputNumbers = "123";
		InputStream inputStream = new ByteArrayInputStream(userInputNumbers.getBytes(StandardCharsets.UTF_8));
		View view = new View(inputStream);

		// when
		Numbers numbers = view.inputNumbers();

		// then
		assertThat(numbers).isEqualTo(Numbers.of(userInputNumbers));
	}
}
