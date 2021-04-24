import java.util.Random;

public class BaseballUtils {

	public String cerateAnswer(){
		String answer = "";
		Random random = new Random();
		int randomNumber;

		for (int i = 0; i < 3; i++) {
			randomNumber = random.nextInt(9) + 1;  // 0 <= iValue < 10
			answer = answer.concat(Integer.toString(randomNumber));
		}
		System.out.println("answer :: " + answer);
		return answer;
	}

	public void checkEqualLength3(final String strValue) {
		if (strValue == null || (strValue.length() != 3)) {
			throw new IllegalArgumentException("3자리 숫자를 입력해주세요!");
		}
	}

	public void checkNumberType(final String strValue) {
		try{
			Integer.parseInt(strValue);
		}catch (NumberFormatException nfp) {
			throw new IllegalArgumentException("숫자만 입력해주세요!");
		}
	}

	public void checkIncludeZero(final String strValue) {
		if(strValue.indexOf('0') > -1) {
			throw new IllegalArgumentException("0을 제외한 1부터 9까지 숫자를 입력해주세요!");
		}
	}

	public void checkNotExistsDupNumbers(final String strValue) {
		int strLength = strValue.length();
		if (!isNotExistsDupNumbers(strValue, strLength)) {
			throw new IllegalArgumentException("중복되는 숫자 없이 입력해주세요!");
		}
	}

	private boolean isNotExistsDupNumbers(final String strValue, final int strLength) {
		for (int i = 0; i < strLength - 1; i++) {
			if (findDupNumber(strValue, i))
				return false;
		}
		return true;
	}

	private boolean findDupNumber(final String strValue, final int i) {
		char targetChar= strValue.charAt(i);
		int tartgetIndex = strValue.indexOf(targetChar, i + 1);

		return i < tartgetIndex;
	}
}
