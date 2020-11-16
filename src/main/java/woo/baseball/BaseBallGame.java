package woo.baseball;

import woo.baseball.business.GameBusiness;

public class BaseBallGame {

	/**
	 * @author : chano
	 * @Date   : 2020. 11. 16.
	 * @Description : 게임 시작 호출
	 * @Method Name : main
	 * @return : void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	  GameBusiness game = new GameBusiness();
	  game.gameStart();
	}

}
