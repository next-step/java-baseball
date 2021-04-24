public class BaseballGame {

	BaseballConsole console;
	BaseballUtils baseballUtils = new BaseballUtils();
	private String answer = "";

	public BaseballGame(BaseballConsole console) {
		this.console = console;
	}

	public String getAnswer() {
		return answer;
	}

	public void initGame() {
		answer = baseballUtils.cerateAnswer();
	}


	public void requestInputNumbers() {
		String attackKeyword;
		boolean checkFlag = false;

		while (!checkFlag) {
			attackKeyword = console.getMessage("숫자를 입력해주세요 : ");
			checkFlag = inputStrValidate(attackKeyword);
		}

	}

	private boolean inputStrValidate(String attackKeyword) {
		try {
			baseballUtils.checkEqualLength3(attackKeyword);
			baseballUtils.checkNumberType(attackKeyword);
			baseballUtils.checkIncludeZero(attackKeyword);
			baseballUtils.checkNotExistsDupNumbers(attackKeyword);
			return true;
		} catch (IllegalArgumentException iae) {
			console.setMessage(iae.getMessage());
			return false;
		}
	}
}
