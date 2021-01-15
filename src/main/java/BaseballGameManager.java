public class BaseballGameManager extends GameManager {

    @Override
    public void gameProcess(Game game){
        this.game = game;
        gameStart();

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameEnd();
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
