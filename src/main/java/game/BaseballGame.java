package game;

import java.util.Random;

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
		//playGame();
	}
	
	private static void playGame() {
		//정답 셋팅
		int[] answer = makeAnswerNumber();
		
		//정답 맞출때까지 반복
		//1. 사용자에게 입력받기
		//2. 판단
		//3. 판단 결과 출력
	}
	
	
	// 3개의 랜덤숫자 정답 설정 (1~9)
	public static int[] makeAnswerNumber() {
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
	
	

}
