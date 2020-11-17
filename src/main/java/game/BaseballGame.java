package game;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	
	/**
	 * * 정답 설정 ( = 3개의 랜덤숫자 생성)
	 * * 사용자에게 숫자 입력받기
	 * * 입력받은 숫자 검증하기
	 *  : 입력된 타입 체크하기 / 중복된 숫자가 있으면 예외처리 하기
	 * * 숫자야구게임 룰에 맞는 판단로직 만들기 ( 스트라이크 / 볼 )
	 * * 판단 결과 출력
	 * * 게임 반복 진행
	 *  : 사용자에게 게임 다시할지 여부 질문 & 결과 반영
	 *   (게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.)
	 *
	 */
	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		
		game.playGame();
		
	}
	
	public void playGame() {
		//정답 셋팅
		int[] answer = makeAnswerNumber();
		
		//정답 맞출때까지 반복
		//1. 사용자에게 입력받기
		int[] user = userNumber();
		
		//2. 판단
		
		//3. 판단 결과 출력
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
	
}
