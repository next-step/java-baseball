package domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Catcher {

    final Ball ball = chooseThreeBall();

    private Ball chooseThreeBall() {

        Set<Integer> comBall = new LinkedHashSet<>();
        while(comBall.size()<=2){
            comBall.add(ThreadLocalRandom.current().nextInt(1, 10));
        }

        return new Ball(comBall);
    }


}
