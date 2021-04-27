package baseball;

class Console {
	private void print(String message) {
		System.out.print(message);
	}

	private void println(String message) {
		System.out.println(message);
	}

	void printJudgement(Judgement judgement) {
		println(judgement.toMessage());
	}

	void printMessageOnBeforeGuess() {
		print("숫자를 입력해주세요 : ");
	}

	void printMessageOnEnd() {
		println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
