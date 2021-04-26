package me.mkhwang.baseball;


import me.mkhwang.baseball.domain.BaseballGame;
import me.mkhwang.baseball.type.GameType;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class BaseballApplication {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        while (baseballGame.getStatus() == GameType.GAME_START){
            baseballGame.round();
        }
    }
}
