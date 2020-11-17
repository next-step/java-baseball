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
            String batting = pitcher.pitch();
            strikeOut = referee.judgeBatting(batting);
        }while (!strikeOut);

        return referee.askFinish();
    }
}