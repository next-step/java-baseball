package referee;

import input.InputApi;
import message.Message;
import output.OutputApi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballCall {
    /*
        판정 메서드
    */
    public static boolean callMethod(String player, String counter){
        int strike = cntStrike(player, counter);
        int ball = cntBall(player, counter, strike);
        boolean ret = false;
        if(strike == 3) {
            OutputApi.output(Message.GAME_OVER);
            return true;
        }
        OutputApi.outputBallCount(strike, ball);
        return false;
    }

    /*
        스트라이크 판정 메서드
    */
    private static int cntStrike(String player, String counter){
        int strike = 0;
        for(int i=0; i<3; i++){
            strike += player.charAt(i) == counter.charAt(i) ? 1 : 0;
        }
        return strike;
    }

    /*
        봂 판정 메서드
    */
    private static int cntBall(String player, String counter, int strike){
        int ball = -strike;
        Set<Character> pitNum = new HashSet<Character>();
        for(int i=0; i<3; i++){
            pitNum.add(player.charAt(i));
        }
        for(int i=0; i<3; i++){
            ball += pitNum.contains(counter.charAt(i)) ? 1 : 0;
        }
        return ball;
    }
}
