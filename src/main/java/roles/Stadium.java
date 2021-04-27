package roles;

import java.util.Scanner;

import utils.IoUtils;

public class Stadium {

	private Hitter hitter = new Hitter();
	private Pitcher pitcher = new Pitcher();
	private Refree refree = new Refree();

	public void playBall() {
		IoUtils.output("Play Ball!!");
		hitter.generateNumber();
		// IoUtils.output(hitter.getNumbers().toString()); // 원활한 게임 시연을 위한 hint
		while (!refree.isOut()) {
			IoUtils.output("숫자를 입력해주세요 : ");
			pitcher.inputGameNumbers();
			refree.judge(hitter.getNumbers(), pitcher.getNumbers());
			IoUtils.output(refree.getJudgement());
		}
		chooseDoOrDie();
	}

	private void chooseDoOrDie() {
		IoUtils.output("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
			+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		if (scanner.nextInt() == 1) {
			reset();
			playBall();
		}
	}

	private void reset() {
		this.hitter = new Hitter();
		this.pitcher = new Pitcher();
		this.refree = new Refree();
	}
}
