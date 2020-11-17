package com.baseball.game.service;

import com.baseball.game.domain.Batter;
import com.baseball.game.domain.Pitcher;

public interface SwingOperator {
    boolean isSwing(Pitcher pitcher, Batter batter, int index);
}
