import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
	
	@Test
	@DisplayName("3자리 난수생성 테스트")
	void createRandomNumberTest() {
		String randomNumber = createRandomNumber();
		assertThat(randomNumber.length()).isEqualTo(3);
	}
	
	private String createRandomNumber() {
		double randomNumber = Math.random() * 1000;
		return String.format("%.0f", randomNumber);
	}
	
	@ParameterizedTest
	@CsvSource( value = {"123:true", "qwe:false", "1f2:false", "'':false", "1111:false"}, delimiter = ':')
	@DisplayName("문자열 유효성 테스트")
	void validateInsertTextTest(String insertText, boolean expected) {
		assertThat(validateInsertText(insertText)).isEqualTo(expected);
	}
	
	private boolean validateInsertText(String insertText) {
		String regExp = "^[0-9]{3}$";
		return insertText.matches(regExp);
	}
	
	@ParameterizedTest
	@CsvSource( value = {"123:true", "qwe:false", "1f2:false", "'':false", "1111:false"}, delimiter = ':')
	@DisplayName("숫자 입력 테스트")
	void insertNumberTest(String insertText, boolean expected) {
		assertThat(insertNumber(insertText).length() == 0).isEqualTo(expected);
	}
	
	private String insertNumber(String insertText) {
		String result = "";
		
		while(!validateInsertText(insertText)) {
			result = BaseballGameConstant.ENTER_CORRECT_NUMBER;
			System.out.println(BaseballGameConstant.ENTER_CORRECT_NUMBER);
			System.out.print(BaseballGameConstant.REQ_ENTER_NUMBER);
			insertText = "123";
		}
		
		return result;
	}
	
	@ParameterizedTest
	@CsvSource( value = {"1:3:0", "1:1:1"}, delimiter = ':')
	@DisplayName("스트라이크 테스트")
	public void checkStrikeTest(String randomNumber, String insertNumber, int expected) {
		assertThat(checkStrike(randomNumber, insertNumber)).isEqualTo( expected );
	}
	
	private int checkStrike(String randomNumber, String insertNumber) {
		if (randomNumber.equals(insertNumber)) {
			return 1;
		}
		return 0;
	}
	
}
