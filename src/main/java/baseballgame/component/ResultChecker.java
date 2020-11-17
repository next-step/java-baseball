package baseballgame.component;

import baseballgame.domain.Result;

import java.util.List;

public class ResultChecker {

    private Result result;

    public static ResultChecker getInstance() {
        return new ResultChecker();
    }

    private ResultChecker() {
        this.result = new Result();
    }

    /**
     * 스트라이크과 볼 카운트 체크
     * @param input : 사용자 입력 숫자
     * @param answer : 정답 숫자
     * @return : 체크 결과
     */
    public Result check(List<Integer> input, List<Integer> answer) {
        for (int i = 0; i < input.size(); i++) {
            addStrikeCount(input.get(i), answer.get(i));
            addBallCount(input.get(i), answer);
        }
        //중복 카운팅된 볼 카운트 계산
        result.getActualBallCount();
        return result;
    }

    private void addStrikeCount(int input, int answer){
        if(input == answer) {
            result.addStrikeCount();
        }
    }

    private void addBallCount(int input, List<Integer> answer){
        if(answer.contains(input)) {
            result.addBallCount();
        }
    }

}
