public class BaseballGame {

	private String answer = "";
	BaseballUtils baseballUtils = new BaseballUtils();

	public void initGame() {
		answer = baseballUtils.cerateAnswer();
	}

	public String getAnswer() {
		return answer;
	}
}
