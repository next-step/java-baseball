package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CreateMessageTest {

	@ParameterizedTest
	@CsvSource(value = {"0:0:낫싱"}, delimiter = ':')
	@DisplayName("Create Message Nothing Check Test")
	void testCreateMessageNothing(int strikeCnt, int ballCnt, String message) {
		assertThat(message).isEqualTo(CreateMessage.getMessage(strikeCnt, ballCnt));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"0:1:1 볼"}, delimiter = ':')
	@DisplayName("Create Message Ball Check Test")
	void testCreateMessageBall(int strikeCnt, int ballCnt, String message) {
		assertThat(message).isEqualTo(CreateMessage.getMessage(strikeCnt, ballCnt));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"2:0:2 스트라이크"}, delimiter = ':')
	@DisplayName("Create Message Strike Check Test")
	void testCreateMessageString(int strikeCnt, int ballCnt, String message) {
		assertThat(message).isEqualTo(CreateMessage.getMessage(strikeCnt, ballCnt));
	}

}
