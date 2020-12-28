public class App {
    public static void main(String[] args){
        Game game = new Game(3);
        while(game.isEnded() != true){
            game.startGame();
        }
    }
}
