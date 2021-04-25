package com.woowahan.precource;

import java.util.ArrayList;

public class BaseBall{
	public int strikeCount;
	public int ballCount;
	public ArrayList<Integer> situation;
	
	public BaseBall(){
		this.strikeCount = 0;
		this.ballCount = 0;
		this.situation = new ArrayList<>();
	}
	void findStrikeCount(BaseBall userBall, ArrayList<Integer> compareBall) {
		
		for(int i = 0; i < 3; i++) {
			if(userBall.situation.get(i) == compareBall.get(i)) {
				this.strikeCount++;
			}
		}
	}
	void findBallCount(BaseBall userBall, ArrayList<Integer> compareBall) {

		for(int i = 0; i < 3; i++) {
			if((userBall.situation.get(i) != compareBall.get(i)) && userBall.situation.contains(compareBall.get(i))) {
				this.ballCount++;
			}
		}

	}

}
