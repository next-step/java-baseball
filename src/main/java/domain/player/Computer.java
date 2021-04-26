package domain.player;

import domain.baseball.Baseball;
import domain.baseball.BaseballGroup;

import java.util.List;

public class Computer {

    private final BaseballGroup baseballGroup;
    private final List<Baseball> baseballList;

    public Computer(BaseballGroup baseballGroup) {
        this.baseballGroup = baseballGroup;
        this.baseballList = baseballGroup.getBaseballList();
    }

    public BaseballGroup getBaseballGroup() {
        return baseballGroup;
    }

    public List<Baseball> getBaseballList() {
        return baseballList;
    }
}
