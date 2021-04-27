package me.mkhwang.baseball.type;

/**
 * Created by mkhwang on 2021/04/26
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public enum GameType {
    GAME_START(1),
    GAME_END(2),
    BALL_LENGTH(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9);

    private int type;

    GameType (int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
