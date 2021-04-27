package baseball;

import java.util.Scanner;

import domain.Game;
import domain.User;
import template.BaseballTemplate;
import util.CreateMessage;

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
		CreateMessage.printEndMsg();
		
		Scanner sc = new Scanner(System.in);
		int statue = sc.nextInt();
		
		if(statue == 1) {
			gameExit = true;
		}

		return gameExit;
	}

}
