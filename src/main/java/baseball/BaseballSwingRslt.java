package baseball;

import domain.Game;
import domain.User;
import util.CreateMessage;

/**
 * 
 * @author 이충선
 *
 * @meno 스윙 결과 생성
 */
public class BaseballSwingRslt {
	
	public Game game = null;
	public User user = null;
	public int[] npcNumber = null;
	public int[] userNumber = null;
	
	int strikeCnt = 0;
	int ballCnt = 0;
	
	
	public BaseballSwingRslt(Game game, User user) {
		this.game = game;
		this.user = user;
		
		npcNumber = game.getNpcNumber();
		userNumber = user.getUserNumber();
	}
	
	public String swingRslt() {
		String rtnMsg = "";
		
		for(int idx = 0; idx < userNumber.length; idx++) {
			strikeChk(idx);
		}
		
		rtnMsg = CreateMessage.getMessage(strikeCnt, ballCnt);
		isFinishYN(strikeCnt);
		strikeCnt = 0;	
		ballCnt = 0;
		
		return rtnMsg;
	}
	
	/**
	 * 
	 * @param idx
	 * @memo 스트라이크 판별
	 */
	public void strikeChk(int idx) {
		int preStrikeCnt = strikeCnt;
		
		strikeCnt += sameChk(npcNumber[idx], userNumber[idx]);
		
		if(preStrikeCnt == strikeCnt) {
			ballChk(idx);
		}
	}
	
	/**
	 * 
	 * @param idx
	 * @memo 볼 판별
	 */
	public void ballChk(int idx) {
		for(int npcIdx = 0; npcIdx < npcNumber.length; npcIdx++) {
			ballCnt += sameChk(npcNumber[npcIdx], userNumber[idx]);
		}
	}
	
	/**
	 * 
	 * @param npc, user
	 * @memo 같은 숫자인지 판별
	 */
	public int sameChk(int npc, int user) {
		if(npc == user) {
			return 1;
		}
		return 0;
	}
	
	public void isFinishYN(int strike) {
		if(strike == 3) {
			game.setGameStauts(0);
		}
	}
}
