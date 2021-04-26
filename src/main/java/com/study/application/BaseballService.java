package com.study.application;

import com.study.application.model.InputModel;
import com.study.domain.BaseballGame;

import java.io.IOException;

import static com.study.domain.BaseballGameConstants.COUNT_NOTHING;
import static com.study.domain.BaseballGameConstants.GAME_BALL;
import static com.study.domain.BaseballGameConstants.GAME_STRIKE;
import static com.study.domain.BaseballGameConstants.NUMBER_LENGTH;

/**
 * @author Jaedoo Lee
 */
public class BaseballService {

    public boolean isContinue(BaseballGame answer, InputModel input) throws IOException {
        if (answer.isCorrect(input.getInputNumber())) {
            answer.generateNewGame();
            return input.isNewGame();
        }

        printCalculateCnt(input.getInputNumber(), answer);
        return true;
    }

    private void printCalculateCnt(int n, BaseballGame game) {
        int strikeCnt = getStrikeCnt(n, game.getAnswer());
        int ballCnt = getBallCnt(n, game.getAnswer());
        String response = COUNT_NOTHING;
        if (strikeCnt != 0 || ballCnt != 0) {
            response = strikeCnt + GAME_STRIKE + " " + ballCnt + GAME_BALL;
        }

        printResponse(response);
    }

    private void printResponse(String mesesage) {
        System.out.println(mesesage);
    }

    private int getStrikeCnt(int n, int answer) {
        int objectNumTmp = answer;
        int inputNumTmp = n;
        int strikeCnt = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            strikeCnt = checkStrikeCnt(objectNumTmp, inputNumTmp, strikeCnt);
            objectNumTmp = objectNumTmp / 10;
            inputNumTmp = inputNumTmp / 10;
        }
        return strikeCnt;
    }

    private int checkStrikeCnt(int objectNumTmp, int inputNumTmp, int strikeCnt) {
        if (objectNumTmp % 10 == inputNumTmp % 10) strikeCnt++;
        return strikeCnt;
    }

    private int getBallCnt(int n, int answer) {
        int objectNumTmp = answer;
        int ballCnt = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            ballCnt = calculateBallCnt(objectNumTmp, n, i, ballCnt);
            objectNumTmp /= 10;
        }
        return ballCnt;
    }

    private int calculateBallCnt(int objectNumTmp, int inputNumTmp, int i, int ballCnt) {
        for (int j = 0; j < NUMBER_LENGTH; j++) {
            ballCnt = equalBallCnt(objectNumTmp, inputNumTmp, ballCnt, i, j);
            inputNumTmp /= 10;
        }
        return ballCnt;
    }

    private int equalBallCnt(int objectNumTmp, int inputNumTmp, int ballCnt, int i, int j) {
        if (objectNumTmp % 10 == inputNumTmp % 10 && i != j) ballCnt++;
        return ballCnt;
    }
    
}
