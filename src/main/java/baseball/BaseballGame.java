package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class BaseballGame {
	public static final int RANDOM_NUMBER_LENGTH = 3;
	
	public static void main(String[] args) {
		try {
			playGame();
		}  catch (Exception e) {
			System.out.println("프로그램 에러 발생, 프로그램을 종료합니다.");
		}
	}
		
	public static void playGame() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			List<Integer> randomIntegerList = generateRandomIntegerList(RANDOM_NUMBER_LENGTH);
			while (!takeBallCount(randomIntegerList, inputBaseballNumber(br))
					.printBallCount()
					.isAllStrike()) {}
			System.out.println(RANDOM_NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임종료");
		} while (isRetryOrEnd(br));
		br.close();
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
	
	public static List<Integer> inputBaseballNumber(BufferedReader br) throws IOException {
		String inputValue = null;
		do {
			System.out.print("숫자를 입력해주세요. ");
			inputValue = br.readLine();
		} while (!validateInputValue(inputValue));
		List<Integer> inputBaseBallNumberList = new ArrayList<>();
		for (int i = 0; i < RANDOM_NUMBER_LENGTH; ++i) {
			inputBaseBallNumberList.add(Character.getNumericValue(inputValue.charAt(i)));
		}
		return inputBaseBallNumberList;
	}
	
	public static boolean validateInputValue(String inputValue) {
		return (isIntegerValue(inputValue) && validateLength(inputValue, 3));
	}
	
	public static boolean isIntegerValue(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean validateLength(final String value, final int length) {
		return value.length() == length;
	}
	
	public static boolean isRetryOrEnd(BufferedReader br) throws IOException {
		do {
			System.out.println("게임을 새로 사작하려면 1, 종료하려면 2를 입력하세요.");
			String inputValue = br.readLine();
			if (inputValue.equals("1")) return true;
			if (inputValue.equals("2")) return false;
		} while (true);
	}
	
	public static BallCount takeBallCount(final List<Integer> randomIntegerList, final List<Integer> inputIntegerList) {
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
		
		public BallCount printBallCount() {
			String ballCountStr = ((strikeCount > 0) ? (strikeCount + " 스트라이크") : "")
					+ ((strikeCount > 0 && ballCount > 0) ? " " : "")
					+ ((ballCount > 0) ? (ballCount + " 볼") : "")
					+ ((nothingCount == totalBallCount) ? "낫싱" : "");
			System.out.println(ballCountStr);
			return this;
		}
		
		public boolean isAllStrike() {
			if(strikeCount == totalBallCount) {
				return true;
			}
			return false;
		}
	}
}
