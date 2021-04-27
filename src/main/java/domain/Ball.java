package domain;

import exception.BallException;
import util.Util;

import java.util.*;

final class Ball {

    List<Integer> balls;

    Ball(String balls){
        setBall(strToList(balls));
    }

    Ball(List<Integer> balls){
        setBall(balls);
    }

    Ball(Set<Integer> balls){
        setBall(new ArrayList<>(balls));
    }

    private void setBall(List<Integer> balls){
        checkNull(balls);
        for(int ball : balls){
            checkNumberValidation(ball);
            checkDuplicate(balls, ball);
        }
        checkSize(balls);
        this.balls = Collections.unmodifiableList(balls);
    }

    private Boolean checkNumberValidation(int ball){
        if(!Util.pattern.matcher(Integer.toString(ball)).find()){
            throw new BallException("1 ~ 9 까지의 숫자를 입력하세요.");
        }
        return true;
    }

    private List<Integer> strToList(String input){
        checkNumber(input);

        List<Integer> ball = new ArrayList<>();

        for(int i=0; i<input.length(); i++){
            ball.add(input.charAt(i)-'0');
        }
        return ball;
    }

    private void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new BallException("숫자만 입력 가능합니다.");
        }
    }

    private void checkNull(List<Integer> balls) {
        if(balls == null){
            throw new BallException("NullPointerException 발생");
        }
    }

    private void checkDuplicate(List<Integer> balls, int ball) {
        int count = Collections.frequency(balls, ball);

        if(count>1){
            throw new BallException("중복되지 않는 숫자를 입력하세요.");
        }
    }

    private void checkSize(List<Integer> balls) {

        Set<Integer> targetSet = new HashSet<>(balls);
        if (targetSet.size() != 3) {
            throw new BallException("숫자 3개를 입력하세요.");
        }
    }

}
