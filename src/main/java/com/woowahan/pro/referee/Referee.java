package com.woowahan.pro.referee;

public interface Referee {
    GameStatus judge(String[] opponentNumbers, String[] playerNumbers);
}
