package com.github.momentjin;

import com.github.momentjin.model.BaseballNumberBundleMatcher;
import com.github.momentjin.model.BaseballNumberBundleValidator;
import com.github.momentjin.model.DefaultBaseballNumberBundleValidator;
import com.github.momentjin.service.BaseballApplicationService;
import com.github.momentjin.service.BaseballNumberBundleFactory;
import com.github.momentjin.service.DefaultBaseballNumberBundleMatcher;
import com.github.momentjin.ui.BaseballGameResultPrinter;
import com.github.momentjin.ui.PlayerConsoleController;
import com.github.momentjin.ui.PlayerInputValidator;

public class BaseballApplication {

    public static void main(String[] args) {

        final BaseballGameResultPrinter baseballGameResultPrinter = new BaseballGameResultPrinter();
        final PlayerInputValidator playerInputValidator = new PlayerInputValidator();
        final BaseballNumberBundleFactory factory = new BaseballNumberBundleFactory();
        final BaseballNumberBundleValidator validator = new DefaultBaseballNumberBundleValidator();
        final BaseballNumberBundleMatcher baseballNumberMatchResult = new DefaultBaseballNumberBundleMatcher(validator);
        final BaseballApplicationService baseballApplicationService = new BaseballApplicationService(baseballNumberMatchResult);

        new PlayerConsoleController(
                baseballGameResultPrinter,
                playerInputValidator,
                factory,
                baseballApplicationService
        ).startGame();
    }
}
