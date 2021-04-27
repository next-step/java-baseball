package numberBaseBallGame.view;

import numberBaseBallGame.domain.BallNumberMatchResult;
import numberBaseBallGame.generator.GenerateGame;
import numberBaseBallGame.ValidationCheckUtils;

import java.util.Scanner;

public class Client {
	private static GenerateGame generateGame;
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		generateGame = new GenerateGame();

		while (true){
			System.out.println("숫자를입력해주세요 : ");
			String gameNumbers = scanner.nextLine();

			try{
				ValidationCheckUtils.checkInputNumber(gameNumbers);
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				continue;
			}

			BallNumberMatchResult gameHintAndResults = generateGame.playGame(gameNumbers);

			if(!gameHintAndResults.isAllMatch()){
				System.out.println(HintMessage.setHintMessage(gameHintAndResults));
				continue;
			}

			System.out.println("3개의숫자를모두맞히셨습니다!게임종료");
			System.out.println("게임을새로시작하려면1,종료하려면 2를입력하세요. (아무키나 누르시면 종료됩니다.) : ");

			String isContinue = scanner.nextLine();

			if(isContinue.equals("1")){
				generateGame = new GenerateGame();
			}

			if(!isContinue.equals("1")){
				System.exit(0);
			}
		}
	}


}
