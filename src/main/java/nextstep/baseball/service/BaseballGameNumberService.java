package nextstep.baseball.service;

import java.util.List;

public interface BaseballGameNumberService {
    List<Integer> inputUserNumber(String str);
    List<Integer> getRandomBox();
    List<Integer> generateComputerNumber();
}
