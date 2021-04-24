package com.nextstep.ppyong;

import com.nextstep.ppyong.validator.DuplicatedNumberValidator;
import com.nextstep.ppyong.validator.OnlyNumberValidator;
import com.nextstep.ppyong.validator.Validator;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Validator> validatorList = Arrays.asList(
          new DuplicatedNumberValidator(),
          new OnlyNumberValidator()
        );
        GameBot gameBot = new GameBot(validatorList);
        gameBot.run();
    }

}
