package com.jyjeong.baseball;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while(game.run()){}
        System.out.println("게임을 종료합니다.");
    }
}
