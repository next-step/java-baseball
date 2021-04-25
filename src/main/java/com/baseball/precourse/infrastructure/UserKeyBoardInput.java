package com.baseball.precourse;

import com.baseball.precourse.baseball.UserInput;

import java.util.Scanner;

public class UserKeyBoardInput implements UserInput {
    private Scanner scanner;
    public UserKeyBoardInput(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
