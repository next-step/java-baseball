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

	public boolean isEqualLength3(final String strValue) {
		return strValue != null && (strValue.length() == 3);
	}

	public boolean isNotExistsDupNumbers(final String strValue) {
		int strLength = strValue.length();

		return scanDupNumber(strValue, strLength);
	}

	private boolean scanDupNumber(final String strValue, final int strLength) {
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
