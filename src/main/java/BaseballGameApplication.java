import generator.NumGenerator;
import input.InputApi;
import message.Message;
import referee.BaseballCall;

public class BaseballGameApplication {
    public static void main(String[] args){
        boolean gameOver = false;
        do{
            String counter = NumGenerator.numGenerator();
            gameStart(counter);
        }while(newGame());

    }
    
    /*
        게임 수행 메서드
     */
    private static void gameStart(String counter){
        boolean gameOver = false;
        while(!gameOver){
            String player = InputApi.input(Message.INPUT, "number");
            gameOver = BaseballCall.callMethod(player, counter);
        }
    }

    /*
        새 게임 여부 확인 메서드
     */
    private static boolean newGame(){
        return InputApi.input(Message.NEW_GAME, "start").equals("1");
    }
}
