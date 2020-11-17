package com.baseballgame;

import com.baseballgame.service.BaseballGameService;
import com.baseballgame.service.GameService;
import com.baseballgame.view.BaseballGameView;
import com.baseballgame.view.GameView;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private GameService gameService;
    private GameView gameView;
    private List<String> tartgetNumber;
    private List<String> userNumber;

    public BaseballGame() {
        this.gameService = new BaseballGameService();
        this.gameView = new BaseballGameView();
        this.tartgetNumber = gameService.generateTargetNum();
    }

    public void start() {
        do {
            userNumber= gameService.changeStringToArray(getUserInputNumber());
        }
        while (!validInputList(userNumber));
        startGame(tartgetNumber ,userNumber );
        return;
    }

    public void startGame(List<String> tartgetNumber, List<String> userNumber){
        if(!gameService.matchNumber(userNumber,tartgetNumber)) {
            printMessage(gameService.assignBallType(userNumber, tartgetNumber));
            start();
        }
        return;
    }

    public void printMessage(Map<String, Object> resultMap) {
        String reseltMsg = gameView.resultMessage(resultMap);
        if("".equals(reseltMsg)){
            reseltMsg += "낫딩";
        }
        System.out.println(reseltMsg);
    }

    public boolean validInputList(List<String> inputList) {
        if(inputList.size() !=3 || inputList.contains("0") || inputList.contains("")) {
            return false;
        }
        return true;
    }

    public String getUserInputNumber() {
        String inputNumber = "";
        while(inputNumber.length() != 3){
            inputNumber = gameView.initGame();
        }
        return inputNumber;
    }

    public boolean isRunning() {
        if(gameView.exitGame() == 1) {
            return true;
        }
        return false;
    }

}
