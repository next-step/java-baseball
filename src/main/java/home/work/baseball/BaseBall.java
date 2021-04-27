package home.work.baseball;

public class BaseBall {
	
	public static void main(String[] args) {
		int numCount = 3;
		boolean continuePlay = true;
		while(continuePlay) {
			Player p1 = new Player("player1", RandomUtils.generateNums(numCount), false);
			Player cpu = new Player("cpu", RandomUtils.generateNums(numCount), true);
			BullsAndCows game = new BullsAndCows(p1, cpu, numCount);
			game.play();
			continuePlay = CommandLineInterface.printWin();
		}
	}

}
