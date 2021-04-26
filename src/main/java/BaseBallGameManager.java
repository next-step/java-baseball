import play.dto.GameResult;
import play.service.BaseBallGamePlayService;
import play.service.GamePlayService;
import ui.service.BaseBallGamerAction;
import ui.type.GameCommand;
import ui.service.GamerAction;
import ui.dto.InputDataDto;
import ui.type.GameMessage;

public class BaseBallGameManager {

	private final GamerAction gamerAction = new BaseBallGamerAction();
	private final GamePlayService gamePlayService = new BaseBallGamePlayService();

	public void run(){
		gamePlayService.init(); // 게임 데이터 초기화 ( 서로 다른 랜덤 숫자 생성 )
		play(); // 게임 플레이
		if(isRestart()){ // 재시작 여부 확인
			run();
		}
	}

	public void play(){
		InputDataDto inputDataDto = gamerAction.inputData(); // 사용자 데이터 입력 받음
		GameResult gameResult = gamePlayService.play(inputDataDto); // 숫자 맞추기 시작
		gamerAction.printConsoleWithLine(gameResult.getResultMessage()); // 게임 결과 출력
		if(gameResult.isFinish()){ // 숫자를 맞추면 끝
			gamerAction.printConsoleWithLine(GameMessage.OUTPUT_GAME_CLEAR.getMessage()); // 게임 종료문구 출력
			return;
		}
		play(); // 아니면 Play
	}

	public boolean isRestart(){
		GameCommand gameCommand = gamerAction.inputCommand();
		return gameCommand.isRestart();
	}

}
