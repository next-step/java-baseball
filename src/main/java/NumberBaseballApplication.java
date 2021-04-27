import baseballnumber.BaseballNumberBoard;
import display.Display;
import gamemaster.GameMaster;
import machine.Machine;
import machine.RandomGenerator;
import player.Player;

public class NumberBaseballApplication {
	public static void main(String[] args) {
		try {
			GameMaster gameMaster = new GameMaster(new Machine(new RandomGenerator()), new Display());
			gameMaster.addPlayer(new Player(new BaseballNumberBoard(0, 0)));
			gameMaster.run();
		} catch (Exception ex) {
			System.out.println("숫자야구 진행 중 에러가 발생했습니다. Message === " + ex.getMessage());
		}
	}
}
