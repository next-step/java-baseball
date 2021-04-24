package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private List<Ball> balls = new ArrayList<>();
	
	public Balls(String ballNumber) {
		registerBallNumber(ballNumber);
	}
	
	private void registerBallNumber(String ballNumber) {

		for(int i=0; i<ballNumber.length();i++) {					
			balls.add(new Ball(String.valueOf(ballNumber.charAt(i))));			
		}
	}
	
	public List<Ball> getBalls(){		
		return this.balls;
	}
}
