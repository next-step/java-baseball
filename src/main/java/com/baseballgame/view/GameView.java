package com.baseballgame.view;

import java.util.Map;

public interface GameView {
    String initGame();
    int exitGame();
    String resultMessage(Map<String, Object> resultMap);

}
