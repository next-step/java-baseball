public class Main {

    static final BaseballGame game = new BaseballGame();
    public static void main(String[] args) {
        boolean isStartGame = true;

        while(isStartGame){
            isStartGame = game.baseballGameStart();
        }
    }

}
