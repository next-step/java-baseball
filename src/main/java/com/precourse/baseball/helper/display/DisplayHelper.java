package com.precourse.baseball.helper.display;


/**
 * 숫자야구 게임 관련 표준 출력에 메시지를 표시하는 클래스
 * 사용방법 : DisplayHelper.inputMessage();
 * @author eoz
 * @version 1.0
 */

public class DisplayHelper {
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요:";
	private static final String INPUT_CONTINUE_MESSAGE = "게임종료 게임을 새로 시작하려면 1, 종료하려면 2 를 입력하세요.";
	private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.(1~9 사이의 정수를 입력해주세요.)";
	
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String STRIKE_MESSAGE = " 스트라이크 ";
	private static final String BALL_MESSAGE = " 볼 ";
	private static final String STRIKE_OUT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";
	 
	
	public static void inputMessage() {
		System.out.println( INPUT_MESSAGE );
	}
	
	public static void wrongInputMessage() {
		System.out.println( INPUT_ERROR_MESSAGE );
	}
	
	public static void strikeOutMessage() {
		System.out.println( STRIKE_OUT_MESSAGE );
	}
	
	/**
	* 스크라이크, 볼 상태를 화면에 표시한다.
	* 둘 중 0일경우는 화면에 표시하지 않는다.
	* @param int strike- 스트라이크 갯수
	* @param int ball- 볼 갯수
	*/
	public static void resultMessage(int strike, int ball) {
		StringBuffer messageSb = new StringBuffer();
		if ( strike != 0 )
			messageSb.append(strike).append( STRIKE_MESSAGE );
		
		if ( ball != 0 )
			messageSb.append(ball).append( BALL_MESSAGE );
		
		System.out.println( messageSb );
	}
	
	public static void nothingMeesage() {
		System.out.println( NOTHING_MESSAGE );
	}
	
	public static void countinueMessage() {
		System.out.println( INPUT_CONTINUE_MESSAGE );
	}
	
}
