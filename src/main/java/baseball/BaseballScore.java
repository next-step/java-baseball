package baseball;

public class BaseballScore {
	private int strike;
	private int ball;
	private boolean endGame;
	private String result;


	BaseballScore(){
		strike = 0;
		ball =0;
		endGame = false;
	}

	public boolean isEndGame(){
		return endGame;
	}
	public void countUpBall() {
		ball++;
	}

	public void countUpStrike() {
		strike++;
		if (strike == 3){
			endGame = true;
		}
	}

	public void getResult(){
		result = "";
		if ((strike + ball) == 0 ){
			result = "낫싱";
			return;
		}
		result += makeStrikeString();
		result += makeBallString();
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

	public void onError() {
		result = "입력 오류 발생 다시 시도해주세요";
	}

	public String getMessage() {
		return result;

	}
}
