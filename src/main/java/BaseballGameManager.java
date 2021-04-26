public class BaseballGameManager {

	private final Questioner questioner;
	private final UserInterface userInterface;

	public BaseballGameManager(Questioner questioner, UserInterface userInterface) {
		this.questioner = questioner;
		this.userInterface = userInterface;
	}

	public static void main(String[] args) {
		BaseballGameManager baseballGame = new BaseballGameManager(new Questioner(), new UserInterface());
	}

}
