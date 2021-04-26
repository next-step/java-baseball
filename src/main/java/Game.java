import java.util.Set;

public class Game {
	private int strike;
	private int ball;
	private String answer; 
	
	private Game(String answer) {
		this.strike = 0;
		this.ball = 0;
		this.answer = answer;		
	}

	public static Game createGame() {
	    String answer = GameUtils.answerGenerator();
		return new Game(answer);
	}	

	public void addStrike() {
		this.strike += 1;		
	}
	
	public void addBall() {
		this.ball += 1;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public int getBall() {
		return ball;
	}
	
	public int getStrike() {
		return strike;
	}
	
	public void setZero() {
		this.strike = 0;
		this.ball = 0;
	}	
}
