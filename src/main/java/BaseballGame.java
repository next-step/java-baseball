import java.util.Scanner;

public class BaseballGame {

	final int NUMBER_SIZE = 3;

	public static void main(String[] args){
		do{
			// TODO: play Baseball game
			BaseballGame baseballGame = new BaseballGame();
			baseballGame.playBaseballGame();

			// TODO: select to replay game
			break;
		}while(true);
	}


	public void playBaseballGame(){
		// TODO: init numbers
		String randomNumbers = getRandomNumbers();

		// get input numbers
		String input = getInput();
		// TODO: show score
		// TODO: check Game status

		System.out.println("Random Numbers: " + randomNumbers);
	}

	public String getRandomNumbers(){
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

	public String getInput(){
		String input;
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		return input;
	}

}
