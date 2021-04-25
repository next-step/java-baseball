package com.baseball.precourse;

import com.baseball.precourse.baseball.Game;
import com.baseball.precourse.baseball.UserInput;
import com.baseball.precourse.infrastructure.UserKeyBoardInput;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInput userInput = new UserKeyBoardInput(new Scanner(System.in));
        Game game = new Game(userInput);
        do {
            game.play();
        } while(!game.isOver());
    }
}
