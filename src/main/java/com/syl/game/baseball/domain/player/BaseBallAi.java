package com.syl.game.baseball.domain.player;

import com.syl.game.baseball.domain.entity.BaseBallNumbers;

public interface BaseBallAi {
    // Generate random numbers.

    /**
     * 임의의 수 3개 생성.
     * @return 임의의 수 3개
     */
    public BaseBallNumbers GenerateRandomNumbers();
}
