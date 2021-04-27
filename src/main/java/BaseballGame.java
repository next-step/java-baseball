import java.util.Scanner;

public class BaseballGame {

	final int NUMBER_SIZE = 3;

	public static void main(String[] args){
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.startGame();
	}

	public void startGame() {
		do{
			// TODO: play Baseball game
			playBaseballGame();

			// TODO: select to replay game
			break;
		}while(true);
	}

	private void playBaseballGame(){
		String randomNumbers = getRandomNumbers();
		String input = getInput();

		Score score = getScore(randomNumbers, input);
		showScore(score);
		// TODO: check Game status

		System.out.println("Random Numbers: " + randomNumbers);
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
				continue;
			}
		}
		return score;
	}

	public boolean isStrike(char input, char randomNumber){
		return input == randomNumber ? true : false;
	}
	public boolean isBall(char input, String randomNumbers){
		return randomNumbers.contains(input+"") ? true : false;
	}

	private void showScore(Score score){
		if(score.getStrikeCount() > 0)
			System.out.print(score.getStrikeCount() + " 스트라이크 ");
		if(score.getBallCount() > 0)
			System.out.print(score.getBallCount() + " 볼");

		System.out.println("");
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
