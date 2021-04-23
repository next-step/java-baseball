package nextstep.baseball.service;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameServiceImpl implements BaseballGameService {
    @Override
    public List<Integer> inputUserNumber(String str) {
        List<Integer> result = new ArrayList<>();
        final String[] split = str.split("");

        for(String i : split){
            result.add(Integer.parseInt(i));
        }
        return result;
    }
}
