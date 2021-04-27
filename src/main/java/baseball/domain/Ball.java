package baseball.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ball {

    public List<Integer> ball;


    public Ball(List<Integer> ball){
        setBall(ball);
    }


    public Ball(String ballStr){
        List<Integer> ball = strToListBall(ballStr);
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

    public List<Integer> strToListBall(String ballStr){

        List<Integer> ballList = new ArrayList<>();
        for(int i=0;i<ballStr.length();i++){
            ballList.add(i, Integer.parseInt(ballStr.substring(i,i+1)));
        }

        return ballList;
    }
}
