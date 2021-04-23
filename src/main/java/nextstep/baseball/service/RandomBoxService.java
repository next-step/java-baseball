package nextstep.baseball.service;

import java.util.List;

public interface RandomBoxService {
    List<Integer> inputUserNumber(String str);
    void setRandomBox();
    List<Integer> createRandomNumber();
}
