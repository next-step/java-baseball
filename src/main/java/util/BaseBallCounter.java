package util;

import domain.BaseBallCount;
import domain.BaseBallNumbers;

public interface BaseBallCounter {
    BaseBallCount count(BaseBallNumbers c, BaseBallNumbers u);
}
