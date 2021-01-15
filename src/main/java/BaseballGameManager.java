public class BaseballGameManager extends GameManager {
    private int start;

    public BaseballGameManager(){
        start = 1;
    }

    @Override
    public void gameProcess(Game game){
        this.game = game;
        while(start == 1){
            gameStart();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            start = getOneOrTwoIntegerInput();
        }
        gameEnd();
    }

    public int getOneOrTwoIntegerInput() {
        int input;
        while (true){
            input = GameManager.userInput.nextInt();
            if (input == 1 || input == 2){
                return input;
            }
            else {
                System.out.println("1 또는 2를 입력해주세요.");
            }
        }
    }


    @Override
    public void gameStart(){
        game.gameRun();
    }

    @Override
    public void gameEnd(){
        System.out.println("프로그램이 종료됩니다.");
    }
}
