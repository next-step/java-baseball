package baseball;

public class BaseballScore {
	private int strike;
	private int ball;

	BaseballScore(){
		strike = 0;
		ball =0;
	}

	public void countUpBall() {
		ball++;
	}

	public void countUpStrike() {
		strike++;
	}

	public String getResult(){
		String result = "";
		if ((strike + ball) == 0 ){
			return "낫싱";
		}
		result += makeStrikeString();
		result += makeBallString();
	return result;
	}

	public String makeStrikeString(){
		if (strike > 0){
			return strike + "스트라이크";
		}
		return "";
	}
	public String makeBallString(){
		if (ball > 0){
				return ball + "볼";
		}
		return "";
	}
}
