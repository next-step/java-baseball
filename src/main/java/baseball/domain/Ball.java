package baseball.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ball {

    public List<Integer> ball;


    public Ball(List<Integer> ball){
        setBall(ball);
    }


    public void setBall(List<Integer> ball){
        this.ball = ball;
    }


    public List<Integer> getBall(){
        return ball;
    }


    public static List<Integer> generateBall(){
        List<Integer> numList = IntStream.range(1,10).boxed().collect(Collectors.toList());
        Collections.shuffle(numList);
        List<Integer> catcherNum  = numList.subList(0,3);

        return catcherNum;
    }
}
