package util;

/**
 * 
 * @author 이충선
 *
 * @memo 스윙 결과 메세지 생성
 */
public class CreateMessage {
	
	private final static String STRIKE = "스트라이크 ";
	private final static String BALL = "볼";
	private final static String NOTHING = "낫싱";
	private final static String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
	private final static String GAME_START_YN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	
	public static String getStrike() {
		return STRIKE;
	}
	public static String getBall() {
		return BALL;
	}
	public static String getNothing() {
		return NOTHING;
	}
	
	public static String getMessage(int strikeCnt, int ballCnt) {
		String rtnMsg = "";
		
		rtnMsg += strikeMsg(strikeCnt);
		
		if(strikeCnt == 3) {
			return rtnMsg;
		}
		
		rtnMsg += ballMsg(ballCnt);
		rtnMsg += nothingYN(rtnMsg);
		
		return rtnMsg;
	}
	
	public static String strikeMsg(int strikeCnt) {
		if(strikeCnt != 0) {
			return strikeCnt + "  " + STRIKE;
		}
		return "";
	}
	
	public static String ballMsg(int ballCnt) {
		if(ballCnt != 0) {
			return ballCnt + "  " + BALL;
		}
		
		return "";
	}
	
	public static String nothingYN(String msg) {
		if("".equals(msg)) {
			return NOTHING;
		}
		
		return "";
	}
	
	public static void printEndMsg() {
		System.out.println(END_GAME);
		System.out.println(GAME_START_YN);
	}
}
