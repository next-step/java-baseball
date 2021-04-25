import display.Display;
import gamemaster.GameMaster;
import machine.Machine;
import player.Player;

public class NumberBaseballApplication {
	public static void main(String[] args) {
		GameMaster gameMaster = new GameMaster(new Machine(123), new Display()); // FIXME : 추후에 숫자 랜덤로직 추가 필요
		gameMaster.addPlayer(new Player());
		gameMaster.run();
	}
}
