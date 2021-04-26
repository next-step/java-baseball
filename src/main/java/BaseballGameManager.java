public class BaseballGameManager {

	private final Questioner questioner;
	private final UserInterface userInterface;

	public BaseballGameManager(Questioner questioner, UserInterface userInterface) {
		this.questioner = questioner;
		this.userInterface = userInterface;
	}

	public static void main(String[] args) {
		BaseballGameManager baseballGame = new BaseballGameManager(new Questioner(), new UserInterface());
		while (baseballGame.execute() == 1);
	}

	public int execute() {
		final int question = questioner.makeProblem();
		String userInput;
		boolean retry = true;
		while (retry) {
			userInput = userInterface.interactUser();
			Referee referee = new Referee(question, userInput);
			retry = !referee.isFinish();
			userInterface.answerTo(referee.judge());
		}
		return userInterface.replayOnNot();
	}

}
