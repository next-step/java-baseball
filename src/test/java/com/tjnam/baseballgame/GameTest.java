package com.tjnam.baseballgame;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    public void gamerInputValidationTest(){
        Boolean isNotValidInput;

        Game game = new Game();

        try {
            Method testMethod = game.getClass().getDeclaredMethod("isValidUserInput", String.class);
            testMethod.setAccessible(true);

            String sameNumberUserInput = "112";
            isNotValidInput = (Boolean) testMethod.invoke(game, sameNumberUserInput);
            assertThat(isNotValidInput).isTrue();

            String overLengthUserInput = "11335566666";
            isNotValidInput = (Boolean) testMethod.invoke(game, overLengthUserInput);
            assertThat(isNotValidInput).isTrue();

            String shortLengthUserInput = "13";
            isNotValidInput = (Boolean) testMethod.invoke(game, shortLengthUserInput);
            assertThat(isNotValidInput).isTrue();

            String notNumberUserInput = "1a3";
            isNotValidInput = (Boolean) testMethod.invoke(game, notNumberUserInput);
            assertThat(isNotValidInput).isTrue();

            String rightUserInput = "135";
            isNotValidInput = (Boolean) testMethod.invoke(game, rightUserInput);
            assertThat(isNotValidInput).isFalse();

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void judgeGameResultTest(){

        Game game = new Game();
        GameResult gameResult = new GameResult();
        Boolean isGameContinue;

        try {
            Method judgeResultMethod = game.getClass().getDeclaredMethod("judgeResult", GameResult.class);
            judgeResultMethod.setAccessible(true);

            //낫싱
            isGameContinue = (Boolean) judgeResultMethod.invoke(game, gameResult);
            assertThat(isGameContinue).isTrue();

            //1ball
            gameResult.addBall();
            isGameContinue = (Boolean) judgeResultMethod.invoke(game, gameResult);
            assertThat(isGameContinue).isTrue();

            //2ball
            gameResult.addBall();
            isGameContinue = (Boolean) judgeResultMethod.invoke(game, gameResult);
            assertThat(isGameContinue).isTrue();

            //2b 1s
            gameResult.addStrike();
            isGameContinue = (Boolean) judgeResultMethod.invoke(game, gameResult);
            assertThat(isGameContinue).isTrue();

            //2s 1b
            gameResult = new GameResult();
            gameResult.addStrike();
            gameResult.addStrike();
            gameResult.addBall();
            isGameContinue = (Boolean) judgeResultMethod.invoke(game, gameResult);
            assertThat(isGameContinue).isTrue();

            //3b
            gameResult = new GameResult();
            gameResult.addBall();
            gameResult.addBall();
            gameResult.addBall();
            isGameContinue = (Boolean) judgeResultMethod.invoke(game, gameResult);
            assertThat(isGameContinue).isTrue();

            //3s
            gameResult = new GameResult();
            gameResult.addStrike();
            gameResult.addStrike();
            gameResult.addStrike();
            isGameContinue = (Boolean) judgeResultMethod.invoke(game, gameResult);
            assertThat(isGameContinue).isFalse();

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void duplicatedInputValidationFuncTest(){
        Game game = new Game();
        Boolean isDuplicate;
        String userInputStringSample;

        try {
            Method checkDuplicateInputMethod = game.getClass().getDeclaredMethod("checkDuplicateInput", String.class);
            checkDuplicateInputMethod.setAccessible(true);

            userInputStringSample = "131";
            isDuplicate = (Boolean) checkDuplicateInputMethod.invoke(game, userInputStringSample);
            assertThat(isDuplicate).isTrue();

            userInputStringSample = "111";
            isDuplicate = (Boolean) checkDuplicateInputMethod.invoke(game, userInputStringSample);
            assertThat(isDuplicate).isTrue();

            userInputStringSample = "115";
            isDuplicate = (Boolean) checkDuplicateInputMethod.invoke(game, userInputStringSample);
            assertThat(isDuplicate).isTrue();

            userInputStringSample = "511";
            isDuplicate = (Boolean) checkDuplicateInputMethod.invoke(game, userInputStringSample);
            assertThat(isDuplicate).isTrue();

            userInputStringSample = "123";
            isDuplicate = (Boolean) checkDuplicateInputMethod.invoke(game, userInputStringSample);
            assertThat(isDuplicate).isFalse();

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void inputIsOnNumberCharValidationTest(){
        Game game = new Game();
        String userInputSample;
        Boolean isNumberString;

        try{
            Method isInputIsNumberStringMethod = game.getClass().getDeclaredMethod("isInputIsNumberString", String.class);
            isInputIsNumberStringMethod.setAccessible(true);

            userInputSample = "13a";
            isNumberString = (Boolean) isInputIsNumberStringMethod.invoke(game, userInputSample);
            assertThat(isNumberString).isTrue();

            userInputSample = "abc";
            isNumberString = (Boolean) isInputIsNumberStringMethod.invoke(game, userInputSample);
            assertThat(isNumberString).isTrue();

            userInputSample = "123";
            isNumberString = (Boolean) isInputIsNumberStringMethod.invoke(game, userInputSample);
            assertThat(isNumberString).isFalse();

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void restartInputTest(){
        int restartInput;
        Boolean result;

        Game game = new Game();

        try {
            Method testMethod = game.getClass().getDeclaredMethod("isValidRestartInput", int.class);
            testMethod.setAccessible(true);

            restartInput = 1;
            result = (Boolean) testMethod.invoke(game, restartInput);
            assertThat(result).isFalse();

            restartInput = 9;
            result = (Boolean) testMethod.invoke(game, restartInput);
            assertThat(result).isTrue();

            restartInput = 2;
            result = (Boolean) testMethod.invoke(game, restartInput);
            assertThat(result).isFalse();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void compareBallsTest(){
        Game game = new Game();
        try {
            Field dealderBall = game.getClass().getDeclaredField("dealerBall");
            dealderBall.setAccessible(true);

            Field gamerBall = game.getClass().getDeclaredField("gamerBall");
            gamerBall.setAccessible(true);

            Method compareBallsMethod = game.getClass().getDeclaredMethod("compareBalls");
            compareBallsMethod.setAccessible(true);

            GameResult gameResult;


            Ball dealerBallInstance = (Ball)dealderBall.get(game);
            Ball gamerBallInstance = (Ball)gamerBall.get(game);

            dealerBallInstance.setBallValues("123");
            gamerBallInstance.setBallValues("123");
            gameResult = (GameResult) compareBallsMethod.invoke(game);
            assertThat(gameResult.strike).isEqualTo(3);

            dealerBallInstance.setBallValues("123");
            gamerBallInstance.setBallValues("132");
            gameResult = (GameResult) compareBallsMethod.invoke(game);
            assertThat(gameResult.strike).isEqualTo(1);
            assertThat(gameResult.ball).isEqualTo(2);

            dealerBallInstance.setBallValues("123");
            gamerBallInstance.setBallValues("456");
            gameResult = (GameResult) compareBallsMethod.invoke(game);
            assertThat(gameResult.strike).isEqualTo(0);
            assertThat(gameResult.ball).isEqualTo(0);

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
