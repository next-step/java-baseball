package common.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import common.code.GameErrorCode;
import common.exception.GameException;

public class ThreeNumbersTest {
	
	@Test
	@DisplayName("Three number object test")
	void ThreeNumbersTest_checkIsValidThreeNumbers() {
		// ** ThreeNumbers(int numbers) ** //
		// 양수, 3자리수 (정상)
		ThreeNumbers threeNumbers = new ThreeNumbers(123);
		assertThat(threeNumbers.getNumber(0)).isEqualTo(1);
		assertThat(threeNumbers.getNumber(1)).isEqualTo(2);
		assertThat(threeNumbers.getNumber(2)).isEqualTo(3);
		
		// 음수
		assertThatThrownBy(()->{
			new ThreeNumbers(-123);
		}, "number는 양수만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		// 3자리수 이하
		assertThatThrownBy(()->{
			new ThreeNumbers(12);
		}, "number 개수는 3개여야한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(1);
		}, "number 개수는 3개여야한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		// 3자리수 이상
		assertThatThrownBy(()->{
			new ThreeNumbers(1234);
		}, "number 개수는 3개여야한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		// 중복
		assertThatThrownBy(()->{
			new ThreeNumbers(111);
		}, "number는 각 자리가 중복되어서는 안된다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_NON_UNIQUE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(121);
		}, "number는 각 자리가 중복되어서는 안된다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_NON_UNIQUE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(221);
		}, "number는 각 자리가 중복되어서는 안된다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_NON_UNIQUE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(103);
		}, "number에 0이 포함되면 안된다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		
		// ** ThreeNumbers(int number1,int number2,int number3) ** //
		// 양수, 3자리수 (정상)
		ThreeNumbers threeNumbers2 = new ThreeNumbers(1,2,3);
		assertThat(threeNumbers2.getNumber(0)).isEqualTo(1);
		assertThat(threeNumbers2.getNumber(1)).isEqualTo(2);
		assertThat(threeNumbers2.getNumber(2)).isEqualTo(3);
		
		// 음수
		assertThatThrownBy(()->{
			new ThreeNumbers(-1,2,3);
		}, "number는 양수만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(1,-2,3);
		}, "number는 양수만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(1,2,-3);
		}, "number는 양수만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(-1,-2,3);
		}, "number는 양수만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(1,-2,-3);
		}, "number는 양수만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(-1,-2,-3);
		}, "number는 양수만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		// 1자리수 이상
		assertThatThrownBy(()->{
			new ThreeNumbers(10,1,2);
		}, "number는 1~9까지만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(1,2,0);
		}, "number는 1~9까지만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(1,1,1);
		}, "number는 중복되어서는 안된다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_NON_UNIQUE_ERROR.getErrorMessage());
		
		assertThatThrownBy(()->{
			new ThreeNumbers(1,3,1);
		}, "number는 중복되어서는 안된다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_NON_UNIQUE_ERROR.getErrorMessage());
		
	}
	
	@Test
	@DisplayName("Get one number of three number test")
	void getThreeNumbersTest_checkIndexOfThreeNumbers() {
		ThreeNumbers threeNumbers = new ThreeNumbers(1,2,3);
		// 2 이상 index
		assertThatThrownBy(()->{
			threeNumbers.getNumber(3);
		}, "index는 0~2까지만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
		
		// 음수 index
		assertThatThrownBy(()->{
			threeNumbers.getNumber(-1);
		}, "index는 0~2까지만 허용한다.").isInstanceOf(GameException.class).hasMessageContaining(GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage());
	}
}
