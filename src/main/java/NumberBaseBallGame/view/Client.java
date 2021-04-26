package NumberBaseBallGame.view;

import NumberBaseBallGame.domain.BallNumberMatchResult;
import NumberBaseBallGame.generater.GenerateGame;
import NumberBaseBallGame.ValidationCheckUtils;

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
				System.out.println(setHintMessage(gameHintAndResults));
				continue;
			}
			System.out.println("3개의숫자를모두맞히셨습니다!게임종료");
			System.out.println("게임을새로시작하려면1,종료하려면 2를입력하세요. : ");

			String isContinue = scanner.nextLine();

			if(isContinue.equals("2")){
				System.exit(0);
			}
			if(isContinue.equals("1")){
				generateGame = new GenerateGame();
			}
		}
	}
	private static String setHintMessage(BallNumberMatchResult matchResult){
		String message = "";
		if(matchResult.isNothing()){
			return BaseBallStatus.NOTHING.getMessage();
		}
		if(matchResult.getStrikeCount()>0){
			message += (BaseBallStatus.STRIKE.getMessage()+matchResult.getStrikeCount()+"볼");
		}
		if(matchResult.getBallCount()>0){
			message += (matchResult.getStrikeCount()+BaseBallStatus.BALL.getMessage());
		}
		return message;
	}
}
