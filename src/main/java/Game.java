public class Game {
	private int humanNum;
	private int enemyNum;
	private int strikeCnt;
	private int ballCnt;

	private Input input;
	private Output output;

	private final int YES = 1;

	public Game() {
		setInput(new Input());
		setOutput(new Output());
	}

	private void setInput(Input input) {
		this.input = input;
	}

	private void setOutput(Output output) {
		this.output = output;
	}

}
