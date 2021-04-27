package baseball.domain;

import baseball.exception.BallException;
import baseball.util.RegexUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ball {

    public List<Integer> ball;

    public Ball(List<Integer> ball) {
        setBall(ball);
    }


    public List<Integer> getBall() {
        return ball;
    }


    public Ball(String ballStr) {
        List<Integer> ball = strToListBall(ballStr);
        setBall(ball);
    }


    public void setBall(List<Integer> ball) {
        validChk(ball);
        this.ball = ball;
    }


    public List<Integer> strToListBall(String ballStr) {
        chkNumeric(ballStr);

        List<Integer> ballList = new ArrayList<>();
        for (int i = 0; i < ballStr.length(); i++) {
            ballList.add(i, Integer.parseInt(ballStr.substring(i, i + 1)));
        }

        return ballList;
    }


    public static List<Integer> generateBall() {
        List<Integer> numList = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(numList);
        List<Integer> catcherNum = numList.subList(0, 3);

        return catcherNum;
    }


    public void validChk(List<Integer> ball) {
        String ballStr = ball.toString().replaceAll("[^0-9]", "");
        chkEmpty(ballStr);
        chkNumeric(ballStr);
        chkNumberSize(ballStr);
        chkZero(ballStr);
        chkDuplicate(ballStr);
    }


    public void chkEmpty(String ballStr) {
        if ("".equals(ballStr)) {
            throw new BallException("숫자를 입력해 주세요.");
        }
    }


    public void chkNumeric(String ballStr) {
        Matcher matcher = RegexUtil.pattern.matcher(ballStr);
        if (!matcher.find()) {
            throw new BallException("숫자만 입력해 주세요.");
        }
    }


    public void chkZero(String ballStr) {
        if (ballStr.contains("0")) {
            throw new BallException("1~9사이의 수만 입력해 주세요.");
        }
    }


    public void chkDuplicate(String ballStr) {
        Set<String> unique = new HashSet<>();
        List<String> numStrList = new ArrayList<>();

        for (int i = 0; i < ballStr.length(); i++) {
            numStrList.add(ballStr.substring(i, i + 1));
        }

        for (String str : numStrList) {
            if (!unique.add(str)) {
                throw new BallException("중복 된 값은 입력할 수 없습니다.");
            }
        }
    }


    public void chkNumberSize(String ballStr) {
        if (ballStr.length() != 3) {
            throw new BallException("세자리의 수를 입력해주세요.");
        }
    }
}
