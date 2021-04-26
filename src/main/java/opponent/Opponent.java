package opponent;

import baseball.BaseballNumber;

import java.util.List;

public interface Opponent {

    List<BaseballNumber> generateAnswer();

    void inputBaseballNumber(List<BaseballNumber> baseballNumbers);

}
