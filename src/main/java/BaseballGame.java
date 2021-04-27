import java.util.Scanner;

public class BaseballGame {

	final int NUMBER_SIZE = 3;

	public static void main(String[] args){
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.startGame();
	}

	public void startGame() {
		do{
			playBaseballGame();
		}while(!checkEnd());
	}

	private boolean checkEnd(){
		System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
		String input = getInput();
		final String GameEnd = "2";
		return input.equals(GameEnd);
	}

	private void playBaseballGame(){
		String randomNumbers = getRandomNumbers();
		while (true) {
			System.out.print("숫자를입력해주세요: ");
			String input = getInput();
			Score score = getScore(randomNumbers, input);
			showScore(score);
			if(isGamePass(score))
				break;
		}
		System.out.println("3개의숫자를모두맞히셨습니다!게임종료");
	}

	public boolean isGamePass(Score score){
		return score.getStrikeCount() == 3;
	}

	public Score getScore(String input, String randomNumbers){
		Score score = new Score();
		for(int i = 0; i < NUMBER_SIZE; i++){
			if(isStrike(input.charAt(i), randomNumbers.charAt(i))) {
				score.setStrikeCount(score.getStrikeCount() + 1);
				continue;
			}
			if(isBall(input.charAt(i), randomNumbers)){
				score.setBallCount(score.getBallCount() + 1);
			}
		}
		return score;
	}

	public boolean isStrike(char input, char randomNumber){
		return input == randomNumber;
	}
	public boolean isBall(char input, String randomNumbers){
		return randomNumbers.contains(input + "");
	}

	private void showScore(Score score){
		if(score.getStrikeCount() > 0)
			System.out.print(score.getStrikeCount() + " 스트라이크 ");
		if(score.getBallCount() > 0)
			System.out.print(score.getBallCount() + " 볼");

		System.out.println();
	}

	private String getRandomNumbers(){
		StringBuilder randomNumber = new StringBuilder();
		for(int i = 0; i < NUMBER_SIZE; ){
			String r = (int)((Math.random() * 9) + 1) + "";
			if(randomNumber.toString().contains(r))
				continue;
			randomNumber.append(r);
			i++;
		}
		return randomNumber.toString();
	}

	private String getInput(){
		String input;
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		return input;
	}

}
