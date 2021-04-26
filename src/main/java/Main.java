public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        BaseBallGame baseBallGame = new BaseBallGame(message);

        while(baseBallGame.isRunning()) {
            baseBallGame.resetGame();
            baseBallGame.setRunning(false);
        }
    }
}
