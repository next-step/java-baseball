import domain.game.Game;
import domain.game.GameStatus;

public class GameApplication {

    public static void main(String[] args){

        Game game = new Game();
        while(game.getStatus() == GameStatus.ONGOING){
            game.play();
        }
    }
}
