import game.system.Pitcher;
import game.system.Referee;

public class GameApplication {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame(){
        boolean lastGame = false;

        do{
            lastGame = playInning();
        }while (!lastGame);
    }

    public static boolean playInning(){
        boolean strikeOut = false;
        Pitcher pitcher = new Pitcher();
        Referee referee = new Referee(pitcher.generateDigits());

        do{
            int battingDigit = pitcher.pitch();
            strikeOut = referee.judgeBatting(battingDigit);
        }while (!strikeOut);

        referee.askContinue();
        return referee.isLastGame();
    }
}