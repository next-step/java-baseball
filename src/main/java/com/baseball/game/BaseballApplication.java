package com.baseball.game;

import com.baseball.game.type.GameState;

import static com.baseball.game.common.Utils.inputNumber;

public class BaseballApplication {
    public static void main(String[] args) {
        System.out.println("================ 프리코스 야구 게임에 오신것을 환영합니다 ================");
        GameState.START.operate();

        while(true){
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
            GameState.findByGameState(inputNumber()).operate();
        }
    }
}
