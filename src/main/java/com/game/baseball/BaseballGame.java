package com.game.baseball;

import com.game.rule.AssignBallRule;
import com.game.ui.PrintMessage;
import com.game.player.GenerationUtil;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    private AssignBallRule assignBallRule;
    private GenerationUtil comGenerationUtil;
    private GenerationUtil userGenerationUtil;
    private PrintMessage printMessage;
    private boolean isRunning = true;

    public BaseballGame(GenerationUtil comGenerationUtil, GenerationUtil userGenerationUtil){
        this.assignBallRule = new AssignBallRule();
        this.printMessage = new PrintMessage();
        this.comGenerationUtil = comGenerationUtil;
        this.userGenerationUtil = userGenerationUtil;
    }

    public void playGame() {
        List<String> comInputList = comGenerationUtil.getTargetNumber();
        while (assignBallRule.getGameFlag()) {
            assignBallRule.infoGameResult(comInputList,userGenerationUtil.getTargetNumber());
            printMessage.printResultMessage(assignBallRule.getStrikeCount(),assignBallRule.getBallCount());
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    public void exitGame() {
        Scanner sacnner = new Scanner(System.in);
        String exitCode = "0";
        while (!("1".equals(exitCode) || "2".equals(exitCode))){
            printMessage.printExitMessage();
            exitCode = sacnner.nextLine();
        }
        if("2".equals(exitCode)){
            setRunning(false);
        }
    }







}
