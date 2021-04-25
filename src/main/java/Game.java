import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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

	private int createEnemyNum() {
		enemyNum = 0;
		List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		Random random = new Random();
		for (int i = 1; i <= 100; i *= 10) {
			int idx = random.nextInt(list.size());
			enemyNum += list.get(idx) * i;
			list.remove(idx);
		}
		return enemyNum;
	}

	private void calcStrikeBallCount() {
		strikeCnt = 0;
		ballCnt = 0;
		String humanNumStr = String.valueOf(humanNum);
		String enemyNumStr = String.valueOf(enemyNum);
		for (int i = 0; i < 3; i++) {
			if (enemyNumStr.charAt(i) == humanNumStr.charAt(i)) {
				strikeCnt++;
			} else if (enemyNumStr.indexOf(humanNumStr.charAt(i)) >= 0) {
				ballCnt++;
			}
		}
	}

	private boolean isThreeStrike() {
		return strikeCnt == 3 ? true : false;
	}

	private void askHumanNumber() {
		output.outputInputNumber();
		humanNum = input.inputByHuman();
	}

	public boolean askWantContinue() {
		return input.inputWantContinuity() == YES;
	}

}
