package numberBaseBallGame.view;

import numberBaseBallGame.ValidationCheckUtils;
import numberBaseBallGame.domain.BallNumberMatchResult;
import numberBaseBallGame.generator.GenerateGame;

import java.util.Scanner;

public class BaseBallGame {
	private static final Scanner scanner = new Scanner(System.in);

	private GenerateGame generateGame;

	public BaseBallGame() {
		this.generateGame = new GenerateGame();
	}

	public void playGame(){
		boolean isContinue = true;

		while (isContinue){
			generateGame = new GenerateGame();

			gaming();

			System.out.println("게임을새로시작하려면1,종료하려면 2를입력하세요. (아무키나 누르시면 종료됩니다.) : ");

			isContinue = isContinue(scanner.nextLine().trim());
		}
	}
	private boolean isContinue(String isContinue){
		if(isContinue.equals("1")){
			generateGame = new GenerateGame();

			return true;
		}

		return false;
	}

	private void gaming(){
		boolean flag = false;

		while (!flag){

			System.out.println("숫자를입력해주세요 : ");
			String gameNumbers = scanner.nextLine().trim();

			flag = setHint(gameNumbers, checkInput(gameNumbers));
		}
	}

	private boolean checkInput(String gameNumbers){
		try {
			ValidationCheckUtils.checkInputNumber(gameNumbers);

		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());

			return false;
		}

		return true;
	}

	private boolean setHint(String gameNumbers, boolean isGo){
		if(!isGo) return isGo;

		BallNumberMatchResult gameHintAndResults = generateGame.playGame(gameNumbers);

		System.out.println(HintMessage.setHintMessage(gameHintAndResults));

		return gameHintAndResults.isAllMatch();
	}
}
