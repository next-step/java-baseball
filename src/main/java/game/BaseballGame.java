package game;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	
	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		boolean replay = false;
		
		do {
			game.playGame();
			
			replay = isReplayGame();
		} while (replay == true);
		
	}
	
	private static boolean isReplayGame() {
		Scanner sc = new Scanner(System.in);
		boolean check;
		String inputValue;
		
		do{
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			inputValue = sc.nextLine();
			check = verifyReplayGameNumber(inputValue);
		} while (!check);
		
		if ("1".equals(inputValue)) {
			return true;
		}
		return false;
	}
	
	private static boolean verifyReplayGameNumber(String input) {
		return ("1".equals(input) || "2".equals(input));
	}
	
	public void playGame() {
		boolean isGameOver = false;
		int[] answer = makeAnswerNumber();
		
		do {
			int[] user = userNumber();
			
			int strikeCount = 0;
			int ballCount = 0;

			strikeCount = checkStrikeCount(answer, user);
			ballCount = checkBallCount(answer, user);
			
			printResult(strikeCount, ballCount);

			if (strikeCount == 3) {
				isGameOver = true;
			}
		} while (isGameOver == false);
	}
	
	
	// 3개의 랜덤숫자 정답 설정 (1~9)
	public int[] makeAnswerNumber() {
		int[] answer = new int[3];
		Random random = new Random();
		
		answer[0] = random.nextInt(9) + 1;
		do {
			answer[1] = random.nextInt(9) + 1;
		} while(answer[0] == answer[1]);
		do {
			answer[2] = random.nextInt(9) + 1;
		} while(answer[0] == answer[2] || answer[1] == answer[2]);
		
		return answer;
	}
	
	//사용자의 숫자 입력을 받는다
	public int[] userNumber() {
		Scanner sc = new Scanner(System.in);
		int[] userNumber;
		
		do {
			try {
				System.out.print("숫자를 입력해주세요 : ");
				userNumber = verifyInputNumber(sc.nextLine());
				return userNumber;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} while(true);
	}
	
	
	//사용자 입력숫자 값 유효성 검증
	public int[] verifyInputNumber(String data){
		if (checkNumberType(data) == false){
			throw new RuntimeException("입력된 값이 숫자가 아닙니다.");
		}
		
		if (containZeroValue(data) == true) {
			throw new RuntimeException("입력된 값에 0이 포함되어 있습니다. 잘못된 입력입니다.");
		}
		
		if (checkInputLength(data) == false){
			throw new RuntimeException("3자리 숫자를 입력해주세요.");
		}
		
		int[] number = stringToIntArray(data);
		if (isUniqueValue(number) == false) {
			throw new RuntimeException("입력된 값에 중복된 숫자가 있습니다. 잘못된 입력입니다.");
		}
		
		return number;
	}
	
	
	private boolean checkNumberType(String data) {
		try {
			Integer.parseInt(data);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
		
	}
	
	private boolean checkInputLength(String data) {
		if (data.isEmpty()) {
			return false;
		}
		if (data.length() == 3) {
			return true;
		}
		return false;
	}
	
	private boolean containZeroValue(String data) {
		return data.contains("0");
	}
	
	private boolean isUniqueValue(int[] num) {
		return (num[0] != num[1]) && (num[0] != num[2]) && (num[1] != num[2]);
	}
	
	public int[] stringToIntArray(String data){
		int[] userNumber = new int[3];
		for(int i = 0 ; i < data.length() ; i++){
			userNumber[i] = Character.digit(data.charAt(i),10);
		}
		return userNumber;
	}
	
	
	// 스트라이크 카운트
	private static int checkStrikeCount(int[] answer, int[] user) {
		int strike = 0;
		if (answer[0] == user[0]) {
			strike++;
		}
		if (answer[1] == user[1]) {
			strike++;
		}
		if (answer[2] == user[2]) {
			strike++;
		}
		return strike;
	}
	
	// 볼 카운트
	private static int checkBallCount(int[] answer, int[] user) {
		int ball = 0;
		if((answer[0] == user[1]) || (answer[0] == user[2])) {
			ball++;
		}
		if((answer[1] == user[0]) || (answer[1] == user[2])) {
			ball++;
		}
		if((answer[2] == user[0]) || (answer[2] == user[1])) {
			ball++;
		}
		return ball;
	}
	
	// 스트라이크, 볼 결과 출력
	private static void printResult(int strikeCount, int ballCount) {
		StringBuilder sb = new StringBuilder();
		if (strikeCount > 0) {
			sb.append(strikeCount + "스트라이크 ");
		}
		if (ballCount > 0) {
			sb.append(ballCount + "볼");
		}
		if (strikeCount == 0 && ballCount == 0) {
			sb.append("낫싱");
		}
		if (strikeCount == 3) {
			sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");
		}
		System.out.println(sb.toString());
	}
	
}
