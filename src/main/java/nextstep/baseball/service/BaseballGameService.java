package nextstep.baseball.service;

import java.util.List;

public interface BaseballGameService {
    List<Integer> inputUserNumber(String str);
    void setRandomBox();
    List<Integer> generateComputerNumber();
}
