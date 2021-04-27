package baseball.domain;

public class ComNumber {

    public Ball ball;

    public ComNumber(){
        //3자리 난수 생성
        ball = new Ball(Ball.generateBall());
    }

}
