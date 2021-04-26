package baseball;

import domain.Game;
import domain.User;

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
		
		rtnMsg = makeMassage();
		strikeCnt = 0;	
		ballCnt = 0;
		
		return rtnMsg;
	}
	
	public void strikeChk(int idx) {
		int preStrikeCnt = strikeCnt;
		
		strikeCnt += sameChk(npcNumber[idx], userNumber[idx]);
		
		if(preStrikeCnt == strikeCnt) {
			ballChk(idx);
		}
	}
	
	public void ballChk(int idx) {
		for(int npcIdx = 0; npcIdx < npcNumber.length; npcIdx++) {
			ballCnt += sameChk(npcNumber[npcIdx], userNumber[idx]);
		}
	}
	
	public int sameChk(int npc, int user) {
		if(npc == user) {
			return 1;
		}
		return 0;
	}
	
	public String makeMassage() {
		String massage = "";
		massage += strikeMsg();
		
		if(strikeCnt == 3) {
			game.setGameStauts(0);
		}
		
		if(ballCnt != 0) {
			massage += ballMsg(massage);
		}
		
		return massage.equals("") ? "³´½Ì" : massage;
	}
	
	public String strikeMsg() {
		if(strikeCnt != 0) {
			return strikeCnt + " ½ºÆ®¶óÀÌÅ©";
		}
		
		return "";
	}
	
	public String ballMsg(String massage) {
		String rtnMsg = "";
		
		if(!"".equals(massage)) {
			rtnMsg += " ";
		}
		
		rtnMsg += ballCnt + " º¼";
		
		return rtnMsg;
	}
}
