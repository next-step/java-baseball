package baseball;

import java.util.Scanner;

import domain.Game;
import domain.User;
import template.BaseballTemplate;

/**
 * 
 * @author 이충선
 *
 */
public class BaseballPlay extends BaseballTemplate {

	public boolean gameExit = false;
	public boolean numberCheck = false;
	public Game game = null;
	public User user = null;
	public BaseballSwingRslt swing = null;
	
	@Override
	public void start() {
		game = new Game();
		user = new User();
	}

	@Override
	public void play() {
		swing = new BaseballSwingRslt(game, user);
		String rsltMessage = "";
		while(game.getGameStauts() == 1) {
			user.swingNumber();
			String rsltMsg = swing.swingRslt();
			System.out.println(rsltMsg);
		}
	}

	@Override
	public boolean end() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		int statue = sc.nextInt();
		
		if(statue == 1) {
			gameExit = true;
		}

		return gameExit;
	}

}
