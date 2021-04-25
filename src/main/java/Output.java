public class Output {
	public void outputInputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void outputWantContinuity() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void outputStrikeBallCount(int strikeCnt, int ballCnt) {
		System.out.println(strikeCnt + " 스트라이크 " + ballCnt + " 볼");
	}

	public void outputFourBall() {
		System.out.println("포볼(낫싱)입니다.");
	}

	public void outputGameCompleted() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
