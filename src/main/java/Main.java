public class Main {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();

        while(baseBallGame.isRunning()) {
            baseBallGame.resetGame();
            baseBallGame.setRunning(false);
        }
    }
}
