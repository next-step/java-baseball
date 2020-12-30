package Model;

import java.util.HashMap;
import java.util.Map;

public enum GameState {
    RESTART(1),
    END(2);

    private int stateId;
    private static HashMap<Integer,GameState> gameStateMap = new HashMap<>();

    GameState(int stateId) {
        this.stateId = stateId;
    }

    static {
        for (GameState gameState : GameState.values()) {
            gameStateMap.put(gameState.stateId, gameState);
        }
    }

    public int getStateId() {
        return this.stateId;
    }

    public static GameState getState(int stateId) {
        return gameStateMap.get(stateId);
    }

}
