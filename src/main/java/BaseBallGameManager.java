import play.BaseBallGamePlay;
import play.GamePlay;
import ui.BaseBallGamerAction;
import ui.GameCommand;
import ui.GamerAction;
import ui.InputDataVO;

public class BaseBallGameManager {

	private final GamerAction gamerAction = new BaseBallGamerAction();
	private final GamePlay gamePlay = new BaseBallGamePlay();

	public void run(){
		// 게임 데이터 초기화
		gamePlay.init();

		// 게임 플레이
		play();

		// 재시작 여부 확인
		if(isRestart()){
			run();
		}
	}

	public void play(){
		// 사용자 데이터 입력 받음
		InputDataVO inputDataVO = gamerAction.inputData();

		// 숫자 맞추기 시작
		boolean isCollect = gamePlay.play(inputDataVO);
		if(isCollect){ // 숫자를 맞추면 끝
			return;
		}
		play(); // 아니면 Play
	}

	public boolean isRestart(){
		GameCommand gameCommand = gamerAction.inputCommand();
		return gameCommand.isRestart();
	}

}
