package nextstep.baseball.service;

import nextstep.baseball.domain.BaseballStatEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballGameCheckServiceImpl implements BaseballGameCheckService {
    @Override
    public Map<String, Integer> getGameResult(List<Integer> player1Number, List<Integer> player2Number) {
        Map<String, Integer> result = new HashMap<>();
        if(Arrays.equals(player1Number.toArray(), player2Number.toArray())){
            result.put(BaseballStatEnum.STRIKE.getCode(),3);
            return result;
        }

        for (int i = 0; i < player1Number.size(); i++) {
            if(i>2){
                continue;
            }
            result.computeIfPresent(checkStrikeBall(i, player1Number.get(i), player2Number), (String key, Integer value) -> ++value);
            result.putIfAbsent(checkStrikeBall(i, player1Number.get(i), player2Number), 1);
        }
        return result;
    }

    private String checkStrikeBall(int idx, int num, List<Integer> computer){
        if(computer.get(idx) == num){
            return BaseballStatEnum.STRIKE.getCode();
        }

        if(computer.contains(num)){
            return BaseballStatEnum.BALL.getCode();
        }

        return BaseballStatEnum.NOTHING.getCode();
    }


}
