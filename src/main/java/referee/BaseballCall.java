package referee;

import input.InputApi;
import message.Message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballCall {
    private static int strike = 0;
    private static int ball = 0;

    public static boolean callMethod(String player, String counter){
        cntStrike(player, counter);
        cntBall(player, counter);
        boolean ret = false;
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            ret = InputApi.input(Message.GAME_START.getMessage(), "start").equals("1") ? true : false;
            return ret;
        }
        System.out.println(strike + " 스트라이크 " + ball + " 볼 ");
        return ret;
    }

    private static void cntStrike(String player, String counter){
        for(int i=0; i<3; i++){
            strike += player.charAt(i) == counter.charAt(i) ? 1 : 0;
        }

    }

    private static void cntBall(String player, String counter){
        ball = -strike;
        Set<Character> pitNum = new HashSet<Character>();
        for(int i=0; i<3; i++){
            pitNum.add(player.charAt(i));
        }
        for(int i=0; i<3; i++){
            ball += pitNum.contains(counter.charAt(i)) ? 1 : 0;
        }
    }
}
