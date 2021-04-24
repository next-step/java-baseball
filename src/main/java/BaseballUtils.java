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
		return answer;
	}

	public void checkEqualLength3(final String strValue) {
		if (strValue == null || (strValue.length() != 3)) {
			throw new IllegalArgumentException("3자리 숫자를 입력해주세요!");
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
