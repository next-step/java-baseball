import generator.NumGenerator;
import input.InputApi;
import referee.BaseballCall;

public class BaseballGame {
    public static void main(String[] args){
        //String player = InputNumber.inputNumber();
        //System.out.println("숫자 입력 성공 : " + pitcher);
        boolean gameOver = false;
        String counter = NumGenerator.numGenerator(3, 1, 9);
        while(!gameOver){
            String player = InputApi.inputNumber();

            gameOver = BaseballCall.callMethod(player, counter);
        }

    }
}
