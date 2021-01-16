public class BaseballGameManager extends GameManager {
    private int start;

    public BaseballGameManager(){
        start = 1;
    }

    @Override
    public void gameProcess(Game game){
        this.game = game;
        while(start == 1){
            startGame();
            start = baseballProcessInput();
        }
        endGame();
    }

    public int baseballProcessInput() {
        System.out.println(SystemMessage.BASEBALL_PROCESS_INPUT);
        String input = GameManager.userInput.next();
        if (input.equals("1") || input.equals("2")) {
            return Integer.parseInt(input);
        } else {
            return baseballProcessInput();
        }
    }


    @Override
    public void startGame(){
        game.run();
    }

    @Override
    public void endGame(){
        System.out.println(SystemMessage.BASEBALL_PROCESS_END_MESSAGE);
    }
}
