package baseball.domain;

import java.util.List;

public class Ball {

    private final int ball;

    private Ball(int ball){
        if(ball < 0 || ball > 3){
            throw new IllegalArgumentException();
        }
        this.ball = ball;
    }


}
