package com.github.momentjin.ui;

import com.github.momentjin.model.BaseballNumber;
import com.github.momentjin.model.BaseballNumberBundle;
import com.github.momentjin.model.BaseballNumberMatchResult;
import com.github.momentjin.service.BaseballApplicationService;
import com.github.momentjin.service.BaseballNumberBundleFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.github.momentjin.model.BaseballNumberConstants.BUNDLE_SIZE;

public class PlayerConsoleController {

    private final BaseballGameResultPrinter baseballGameResultPrinter;
    private final PlayerInputValidator playerInputValidator;
    private final BaseballNumberBundleFactory factory;
    private final BaseballApplicationService baseballApplicationService;

    public PlayerConsoleController(
            BaseballGameResultPrinter baseballGameResultPrinter,
            PlayerInputValidator playerInputValidator,
            BaseballNumberBundleFactory factory,
            BaseballApplicationService baseballApplicationService
    ) {
        this.baseballGameResultPrinter = baseballGameResultPrinter;
        this.playerInputValidator = playerInputValidator;
        this.factory = factory;
        this.baseballApplicationService = baseballApplicationService;
    }

    public void startGame() {

        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {

            System.out.println("숫자 야구 게임 시작!\n");
            BaseballNumberBundle answer = generateAnswer();
            startOneGame(scanner, answer);
            isContinue = enterContinue(scanner);
        }
    }

    private void startOneGame(Scanner scanner, BaseballNumberBundle answer) {

        boolean continueGame = true;
        while (continueGame) {
            BaseballNumberBundle enteredBundle = enterBaseballNumbers(scanner);
            BaseballNumberMatchResult result = baseballApplicationService.checkAnswer(answer, enteredBundle);
            baseballGameResultPrinter.printResult(result);
            continueGame = !result.isMatch() || result.isError();
        }
    }

    private boolean enterContinue(Scanner scanner) {

        System.out.println("게임을 그만하시려면 n을, 계속하시려면 아무키를 눌러주세요!");
        String s = scanner.nextLine().trim().toLowerCase();

        return !s.equals("n");
    }

    private BaseballNumberBundle enterBaseballNumbers(Scanner sc) {

        System.out.println("도전! "+ BUNDLE_SIZE + "자리 수를 입력해주세요.");
        String inputNumbers = "";
        boolean isNotValidated = true;

        while (isNotValidated) {
            inputNumbers = sc.nextLine();
            ValidatorResultBundle validationResult = playerInputValidator.validate(inputNumbers, BUNDLE_SIZE);
            printInputValidationError(validationResult);
            isNotValidated = validationResult.isError();
        }

        return convertToBaseballNumberBundle(inputNumbers);
    }

    private void printInputValidationError(ValidatorResultBundle validationResult) {
        for (ValidatorResult result : validationResult.getResultsHasError()) {
            System.out.println(result.getErrorMessage());
        }
    }

    private BaseballNumberBundle convertToBaseballNumberBundle(String inputNumbers) {

        List<BaseballNumber> list = new ArrayList<>();
        for (char n : inputNumbers.toCharArray()) {
            list.add(new BaseballNumber(Character.getNumericValue(n)));
        }

        return new BaseballNumberBundle(list);
    }

    private BaseballNumberBundle generateAnswer() {
        return factory.generate(BUNDLE_SIZE);
    }
}