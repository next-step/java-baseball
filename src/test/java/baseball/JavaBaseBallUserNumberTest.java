package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavaBaseBallUserNumberTest {
	
	JavaBaseBallUserNumber baseBallUserNumber = new JavaBaseBallUserNumber();

	@Test
	@DisplayName("�Էµ� ���� �������� üũ�Ѵ�.")
	void validateUserNumberTest() {
		assertThat(baseBallUserNumber.validateUserNumber("2a3"))
			.isEqualTo(false);
	}
	
	@Test
	@DisplayName("������ ���̰� 3���� üũ�Ѵ�.")
	void checkUserNumberLengthTest() {
		assertThat(baseBallUserNumber.checkUserNumberLength("243"))
			.isEqualTo(true);
	}
}
