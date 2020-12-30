package game;

import common.GameMode;
import common.GameGuidePhrases;
import common.GameOption;
import exception.GameInputInvalidException;
import exception.ReplayInputOutBoundException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameProgram {

    private Scanner scanner;
    private GameMode gameMode;
    private GameProcessInfo gameProcessInfo;
    private GameScoreInfo gameScoreInfo;

    public void start() {
        List<String> userInputArray = null;
        initProgram();

        do {
            gameMode = GameMode.PLAY;
            userInputArray = getInputToUser();
            gameScoreInfo = getGameScoreInfoToCompareNumbers(userInputArray);
        } while (!isGameEndStatus(gameScoreInfo)
                || isReplayGame());
    }

    public void initProgram() {
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        gameProcessInfo = new GameProcessInfo();
    }

    private List<String> getInputToUser() {
        List<String> inputList = null;
        boolean isCorrectInput = false;

        while (!isCorrectInput) {
            try {
                System.out.print(GameGuidePhrases
                        .INIT_INPUT_GUIDE
                        .replaceAll("\\{\\}",String.valueOf(GameOption.RANDOM_NUMBER_COUNT)));
                inputList = Arrays.asList(scanner
                        .nextLine()
                        .split(GameGuidePhrases.SPLIT_PARAMETER));
                isCorrectInput = checkInputValid(inputList);

            } catch (NumberFormatException | GameInputInvalidException exception) {
                System.out.println(GameGuidePhrases
                        .WRONG_INPUT_GUIDE
                        .replaceAll("\\{\\}",String.valueOf(GameOption.RANDOM_NUMBER_COUNT)));
            }
        }

        return inputList;
    }

    private boolean checkInputValid(List<String> inputArrayList)
            throws GameInputInvalidException, NumberFormatException {

        if (inputArrayList.size() != GameOption.RANDOM_NUMBER_COUNT) {
            throw new GameInputInvalidException();
        }

        for(int idx = 0; idx < GameOption.RANDOM_NUMBER_COUNT; idx++){
            checkStringNumberFormat(inputArrayList.get(idx));
            checkEachDifferentNumber(idx,inputArrayList);
        }

        return true;
    }

    private void checkStringNumberFormat(String number) throws NumberFormatException {
        if (number.charAt(0) < '0' || number.charAt(0) > '9') {
            throw new NumberFormatException();
        }
    }

    private void checkEachDifferentNumber(int idx, List<String> inputArrayList) throws GameInputInvalidException {
        if (inputArrayList.get(idx).equals(
                inputArrayList.get((idx+1) % GameOption.RANDOM_NUMBER_COUNT))) {
            throw new GameInputInvalidException();
        }
    }

    private GameScoreInfo getGameScoreInfoToCompareNumbers(List<String> userInputArray) {
        GameScoreInfo compareResult = new GameScoreInfo();

        for (int idx = 0; idx < GameOption.RANDOM_NUMBER_COUNT; idx++) {
            getScoreToIdxNumber(idx, compareResult, userInputArray);
        }

        System.out.println(compareResult.makeScoreResultString());

        return compareResult;
    }

    private void getScoreToIdxNumber(int idx, GameScoreInfo compareResult, List<String> userInputArray) {
        if (userInputArray.get(idx).equals(gameProcessInfo.getRandomNumberArray().get(idx))) {
            compareResult.addOneStrikeCount();
            return;
        }

        if (gameProcessInfo.getRandomNumberArray().contains(userInputArray.get(idx))) {
            compareResult.addOneBallCount();
        }
    }

    private boolean isGameEndStatus(GameScoreInfo gameScoreInfo) {
        return gameScoreInfo.getStrikeCount() == GameOption.RANDOM_NUMBER_COUNT;
    }

    private boolean isReplayGame() {
        int replayInput = 0;
        boolean isReplay = false;

        while (replayInput != GameMode.PLAY.number
                && replayInput != GameMode.END.number) {
            try {
                System.out.println(GameGuidePhrases.INIT_REPLAY_INPUT_GUIDE);
                replayInput = Integer.parseInt(scanner.nextLine());
                checkReplayInputValid(replayInput);
            } catch (NumberFormatException | ReplayInputOutBoundException exception) {
                System.out.println(GameGuidePhrases.WRONG_REPLAY_INPUT_GUIDE);
            }
        }

        if (replayInput == GameMode.PLAY.number) {
            initProgram();
            isReplay = true;
        }

        return isReplay;
    }

    private void checkReplayInputValid(int replayInput) throws ReplayInputOutBoundException {
        if (replayInput < GameMode.PLAY.number || replayInput > GameMode.END.number) {
            throw new ReplayInputOutBoundException();
        }

        if (replayInput == GameMode.END.number) {
            gameMode = GameMode.END;
        }
    }

}
