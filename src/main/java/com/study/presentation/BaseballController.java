package com.study.presentation;

import com.study.application.BaseballService;
import com.study.domain.BaseballGame;
import com.study.domain.BaseballGameConstants;
import com.study.presentation.request.InputRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jaedoo Lee
 */
public class BaseballController {

    private final BaseballService game;

    public BaseballController() {
        game = new BaseballService();
    }

    public void play() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputRequest request = new InputRequest(br);
        BaseballGame number = new BaseballGame();

        do {
            System.out.print(BaseballGameConstants.INPUT_NUMBER);
        } while (game.isContinue(number, request.toModel()));

        br.close();
    }
}
