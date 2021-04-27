package baseball;

import baseball.util.GameStatus;

public class MatchChecker {
	int strike = 0;
    int ball = 0;
    
    public MatchChecker(Baseball answer, Baseball userTryInput) {
    	 for (int i = 0; i < answer.getBaseballSize(); i++) {
         	checkloop(answer, userTryInput, i);
         }
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	private void checkloop(Baseball answer, Baseball userTryInput, int i) {
		if (checkStrike(answer.getNumber(i), userTryInput.getNumber(i))) {
			strike++;
        }
        else if (checkBall(answer.getNumber(i), userTryInput)) {
            ball++;
        }
	}
	
	private boolean checkStrike(int num1, int num2) {
		return (num1 == num2);
	}
	
	private boolean checkBall(int num1, Baseball ball2) {
		return ContainsChecker.isContains(ball2.getBaseball(), num1);
	}
	
	public boolean isAnswer() {
		return (this.strike == GameStatus.BALL_SIZE);
	}

}
