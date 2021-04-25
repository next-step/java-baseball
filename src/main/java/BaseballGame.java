import java.util.Scanner;

public class BaseballGame {

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

		// get input numbers
		String input = getInput();
		// TODO: show score
		// TODO: check Game status
	}

	public String getInput(){
		String input = "";
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		return input;
	}

}
