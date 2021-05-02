package start.game;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBalls(answers);
        
    }

    private static List<Ball> mapBalls(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for( int index = 0; index < 3; index++ ) {
            balls.add(new Ball(index+1, answers.get(index)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map( answer -> answer.play(userBall) )
                .filter( BallStatus :: isNothing )
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBall = new Balls(balls);
        PlayResult reuslt = new PlayResult();
        for( Ball ball : answers ) {
            BallStatus status = userBall.play(ball);
            reuslt.report( status );
        }
        return reuslt;
    }

}
