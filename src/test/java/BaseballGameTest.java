import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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
	
	@ParameterizedTest
	@CsvSource( value = {"0:3:1", "1:1:0"}, delimiter = ':')
	@DisplayName("볼 테스트")
	public void checkBallTest(int strikeScore, String insertNumber, int expected) {
		String[] randomNumberArr = {"1", "3", "5"};
		assertThat(checkBall( strikeScore, randomNumberArr, insertNumber )).isEqualTo(expected);
	}
	
	private int checkBall(int strikeScore, String[] randomNumberArr, String insertNumber ) {
		if (strikeScore > 0) {
			return 0;
		}
		
		if ( Arrays.asList(randomNumberArr).contains(insertNumber)) {
			return 1;
		}
		return 0;
	}
	
	@ParameterizedTest
	@CsvSource( value = {"3:0:false", "0:0:true", "1:2:false"}, delimiter = ':')
	@DisplayName("낫싱 테스트")
	public void checkNothingTest(int totalStrikeScore, int totalBallScore, boolean expected) {
		assertThat(checkNothing(totalStrikeScore, totalBallScore)).isEqualTo(expected);
	}
	
	private boolean checkNothing(int totalStrikeScore, int totalBallScore ) {
		if (totalStrikeScore == 0 && totalBallScore == 0) {
			System.out.println(BaseballGameConstant.NOTHING);
			return true;
		}
		return false;
	}
	
	@ParameterizedTest
	@CsvSource( value = {"3:true", "1:false", "0:false"}, delimiter = ':')
	@DisplayName("3스트라이크 테스트")
	public void checkThreeStrikeTest(int totalStrikeScore, boolean expected) {
		assertThat(checkThreeStrike(totalStrikeScore)).isEqualTo(expected);
	}
	
	private boolean checkThreeStrike(int totalStrikeScore) {
		if (totalStrikeScore == 3) {
			System.out.println(totalStrikeScore + BaseballGameConstant.STRIKE);
			System.out.println(BaseballGameConstant.CORRECT_ANSWER);
			return true;
		}
		
		return false;
	}
	
	@ParameterizedTest
	@CsvSource( value = {"1:2:false", "0:0:false", "3:0:true"}, delimiter = ':')
	@DisplayName("결과 값 산출 테스트")
	public void getResultTest(int totalStrikeScore, int totalBallScore, boolean expected) {
		assertThat(getResult(totalStrikeScore, totalBallScore)).isEqualTo(expected);
	}
	
	private boolean getResult(int totalStrikeScore, int totalBallScore) {
		if (checkNothing(totalStrikeScore, totalBallScore)) {
			return false;
		}
		
		if (checkThreeStrike(totalStrikeScore)) {
			return true;
		}
		
		String result = totalStrikeScore + BaseballGameConstant.STRIKE
								+ totalBallScore + BaseballGameConstant.BALL;
		System.out.println(result);
		return false;
	}
	
	@ParameterizedTest
	@CsvSource( value = {"345:false", "333:false", "321:true"}, delimiter = ':')
	@DisplayName("점수 산출 테스트")
	public void scorePointsTest(String insertNumber, boolean expected) {
		String randomNumber = "321";
		assertThat(scorePoints(randomNumber, insertNumber)).isEqualTo(expected);
	}
	
	private boolean scorePoints(String randomNumber, String insertNumber) {
		String[] randomNumberArr = randomNumber.split("");
		String[] insertNumberArr = insertNumber.split( "");
		
		int totalStrikeScore = 0;
		int totalBallScore = 0;
		for (int i=0; i<insertNumberArr.length; i++) {
			int roundStrikeScore = checkStrike(randomNumberArr[i], insertNumberArr[i]);
			totalStrikeScore += roundStrikeScore;
			totalBallScore += checkBall(roundStrikeScore, randomNumberArr, insertNumberArr[i]);
		}
		return getResult(totalStrikeScore, totalBallScore);
	}
	
}
