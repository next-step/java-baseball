package nextstep.baseball.service;

import nextstep.baseball.domain.BaseballEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballGameCheckServiceImpl implements BaseballGameCheckService {
    @Override
    public Map<String, Integer> getGameResult(List<Integer> player1Number, List<Integer> player2Number) {
        Map<String, Integer> result = new HashMap<>();
        if(Arrays.equals(player1Number.toArray(), player2Number.toArray())){
            result.put(BaseballEnum.STRIKE.getCode(),3);
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
            return BaseballEnum.STRIKE.getCode();
        }

        if(computer.contains(num)){
            return BaseballEnum.BALL.getCode();
        }

        return BaseballEnum.NOTHING.getCode();
    }

    @Override
    public StringBuffer resultPrint(Map<String, Integer> result){
        StringBuffer stringBuffer = new StringBuffer();

        if(result.get(BaseballEnum.STRIKE.getCode()) != null){
            stringBuffer.append(result.get(BaseballEnum.STRIKE.getCode()));
            stringBuffer.append(BaseballEnum.STRIKE.getName());
        }

        if(result.get(BaseballEnum.BALL.getCode()) != null){
            stringBuffer.append(result.get(BaseballEnum.BALL.getCode()));
            stringBuffer.append(BaseballEnum.BALL.getName());
        }

        if(stringBuffer.length() == 0){
            stringBuffer.append(result.get(BaseballEnum.NOTHING.getCode()));
        }
        return stringBuffer;
    }
}
