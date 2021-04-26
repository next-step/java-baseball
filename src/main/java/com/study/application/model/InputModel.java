package com.study.application.model;

import com.study.application.enums.InputGameContinue;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Jaedoo Lee
 */
public class InputModel {
    private int inputNumber;
    private BufferedReader br;

    public InputModel(int inputNumber, BufferedReader br) {
        this.inputNumber = inputNumber;
        this.br = br;
    }

    public int getInputNumber() {
        return this.inputNumber;
    }
    
    public boolean isNewGame() {
        return InputGameContinue.NEW_GAME.equals(checkInput(br));
    }

    private InputGameContinue checkInput(BufferedReader br) {
        int input = 0;
        try {
            input = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            return InputGameContinue.EXIT_GAME;
        }

        if (isExitGame(input)) return InputGameContinue.EXIT_GAME;
        return InputGameContinue.NEW_GAME;
    }

    private boolean isExitGame(int input) {
        return !InputGameContinue.NEW_GAME.getValue().equals(input);
    }
}
