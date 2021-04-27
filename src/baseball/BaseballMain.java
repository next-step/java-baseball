package baseball;

import baseball.player.PlayerScanner;

public class BaseballMain {

	public static void main(String[] args) {
        do {
            Baseball answerBaseball = BaseballNumberGenerator.CreateNumber();
            play(answerBaseball);
        } while(PlayerScanner.checkRestart());
    }

    public static void play(Baseball answer) {
        boolean isAnswer = true;
        do {
        	PrintMessage.PrintRequestNumberMessage();
        	Baseball userTryInput = PlayerScanner.makeBall();        	
            MatchChecker result = new MatchChecker(answer, userTryInput);
            PrintMessage.PrintResultMessage(result);            
            isAnswer = result.isAnswer();
        } while (!isAnswer);
        PrintMessage.PrintWinMessage();
        PrintMessage.PrintRestartMessage();
    }
    
}
