package NumberBaseBallGame;

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

			GameHintAndResults gameHintAndResults = generateGame.playGame(gameNumbers);
			if(!gameHintAndResults.isFinish()){
				System.out.println(gameHintAndResults.getHint());
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
}
