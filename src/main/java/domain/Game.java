package domain;

import util.GenerateNumber;

/**
 * 
 * @author ¿Ã√Êº±
 *
 * @memo Game domain
 * 
 */
public class Game {

	private final static int NUMBER_LENGTH = 3;
	private int[] npcNumber = null;
	private int gameStauts = 0;
	
	public Game() {
		GenerateNumber gn = new GenerateNumber();
		this.npcNumber = gn.generateNumber(NUMBER_LENGTH);
		setGameStauts(1);
	}
	
	public int getGameStauts() {
		return gameStauts;
	}

	public void setGameStauts(int gameStauts) {
		this.gameStauts = gameStauts;
	}

	public static int getNUMBER_LENGTH() {
		return NUMBER_LENGTH;
	}

	public int[] getNpcNumber() {
		return npcNumber;
	}

	public void setNpcNumber(int[] npcNumber) {
		this.npcNumber = npcNumber;
	}
	
}
