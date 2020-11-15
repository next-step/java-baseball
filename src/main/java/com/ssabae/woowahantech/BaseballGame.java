package com.ssabae.woowahantech;

import com.ssabae.woowahantech.domain.Judgment;
import com.ssabae.woowahantech.domain.baseballnumber.BaseballNumbers;
import com.ssabae.woowahantech.domain.baseballnumber.BaseballNumbersFactory;
import com.ssabae.woowahantech.presentation.UserInputHelper;
import com.ssabae.woowahantech.presentation.UserInputNumberParser;
import com.ssabae.woowahantech.validator.BaseballNumberValidator;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class BaseballGame {

    private final UserInputHelper inputHelper;
    private final Judgment judgment;

    public BaseballGame() {
        UserInputNumberParser parser = new UserInputNumberParser();
        BaseballNumberValidator validator = new BaseballNumberValidator();
        inputHelper = new UserInputHelper(parser, validator);
        judgment = new Judgment();
    }

    public void playBall() {
        do {
            BaseballNumbers gameNumber = BaseballNumbersFactory.generator();
            playingGame(gameNumber);
        } while(confirmContinueGame());
    }

    private void playingGame(BaseballNumbers gameNumber) {
        boolean isCorrect;
        do {
            isCorrect = game(gameNumber);
        } while (!isCorrect);
    }

    private boolean confirmContinueGame() {
        return inputHelper.getInputContinueGame();
    }

    private boolean game(BaseballNumbers baseballNumbers) {
        BaseballNumbers inputBaseBallNumber = inputHelper.getInputBaseBallNumber();
        return judgment.isCorrect(baseballNumbers, inputBaseBallNumber);
    }
}
