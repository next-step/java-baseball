package baseball;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class BaseballGame {
	public static void main(String[] args) {
		
	}
	
	public static List<Integer> generateRandomIntegerList(int randLength) {
		Random rand = new Random();
		List<Integer> randList = new ArrayList<Integer>();
		for(int i = 0; i < randLength; ++i) {
			Integer randomIntValue = null;
			do {
				randomIntValue = rand.nextInt(8) + 1;
			} while(randList.contains(randomIntValue));
			randList.add(randomIntValue);
		}
		return Collections.unmodifiableList(randList);
 	}
	
	public static BallCount ballCount(final List<Integer> inputIntegerList, final List<Integer> randomIntegerList) {
		int len = randomIntegerList.size();		
		BallCount ballCount = new BallCount(len);
		for(int i = 0; i < len; ++i) {
			countStrikeOrBallElseNothing(inputIntegerList.get(i), randomIntegerList.get(i), randomIntegerList, ballCount);
		}
		return ballCount;
	}
	
	public static void countStrikeOrBallElseNothing(final int inputValue, final int randomValue, final List<Integer> randomIntegerList, final BallCount ballCount) {
		if(inputValue == randomValue) {
			ballCount.addStrikeCount(1);
			return;
		}
		if(randomIntegerList.contains(inputValue)) {
			ballCount.addBallCount(1);
			return;
		}
		ballCount.addNothingCount(1);
	}
	
	public static class BallCount {
		private int strikeCount = 0;
		private int ballCount = 0;
		private int nothingCount = 0;
		private int totalBallCount = 0;
		
		public BallCount(int totalBallCount)  {
			this.totalBallCount = totalBallCount;
		}
		
		public void addStrikeCount(int cnt) {
			this.strikeCount += cnt;
		}
		
		public void addBallCount(int cnt) {
			this.ballCount += cnt;
		}
		
		public void addNothingCount(int cnt) {
			this.nothingCount += cnt;
		}
		
		public void printBallCount() {			
			String[] ballCountStrArr = {"", ""};
			if(strikeCount > 0) ballCountStrArr[0] = strikeCount + " 스트라이크";
			if(ballCount > 0) ballCountStrArr[1] = ballCount + " 볼";
			if(nothingCount == totalBallCount) ballCountStrArr[0] = "낫싱";
			System.out.println(String.join(" ", ballCountStrArr));
		}
		
		public boolean isAllStrike() {
			if(strikeCount == totalBallCount) {
				return true;
			}
			
			return false;
		}
	}
}
