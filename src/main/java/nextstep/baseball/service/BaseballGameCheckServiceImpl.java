package nextstep.baseball.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballGameCheckServiceImpl implements BaseballGameCheckService {
    @Override
    public Map<String, Integer> getGameResult(List<Integer> player1Number, List<Integer> player2Number) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < player1Number.size(); i++) {
            result.computeIfPresent(checkStrikeBall(i, player1Number.get(i), player2Number), (String key, Integer value) -> ++value);
            result.putIfAbsent(checkStrikeBall(i, player1Number.get(i), player2Number), 1);
        }
        return result;
    }

    private String checkStrikeBall(int idx, int num, List<Integer> computer){
        if(computer.get(idx) == num){
            return "strike";
        }

        if(computer.contains(num)){
            return "ball";
        }

        return "nothing";
    }
}
