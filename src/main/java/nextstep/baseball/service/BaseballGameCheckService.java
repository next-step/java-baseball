package nextstep.baseball.service;

import java.util.List;
import java.util.Map;

public interface BaseballGameCheckService {
    Map<String, Integer> getGameResult(List<Integer> player1Number, List<Integer> player2Number);
}
