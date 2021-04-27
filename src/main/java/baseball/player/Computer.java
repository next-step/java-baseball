package baseball.player;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> ready(int ballCount){
        List<Integer> ball = new ArrayList<>();
        while(ball.size() < ballCount){
            int num = selectBall();
            if (!checkDuplicateBall(ball, num)) {
                ball.add(num);
            }
        }
        return ball;
    }


    public int selectBall(){
        return  (int) (Math.random() *9)+1;
    }

    public boolean checkDuplicateBall(List<Integer> list, int num){
        if (list.contains(num)) {
            return true;
        }
        return false;
    }

}
