public class BaseballGame {
    private String baseballNumber; // 랜덤 숫자
    private String inputNumber; // 입력 값
    private boolean isContinuing = true; // 게임 진행을 계속할지 여부
    private boolean isSuccess = true; // 결과가 맞는지 여부
    private String resultMessage; // 결과 메시지
    private BaseballNumberGenerator numberGenerator;
    private BaseballNumberValidator validator;
    private BaseballNumberEvaluator evaluator;

    public BaseballGame(BaseballNumberGenerator numberGenerator, BaseballNumberValidator validator, BaseballNumberEvaluator evaluator) {
        assert numberGenerator != null;
        assert validator != null;
        assert evaluator != null;
        this.numberGenerator = numberGenerator;
        this.validator = validator;
        this.evaluator = evaluator;
    }

    public String getBaseballNumber() {
        return baseballNumber;
    }

    public void setBaseballNumber(String baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public boolean continuing() {
        return isContinuing;
    }

    public void setContinuing(boolean continuing) {
        isContinuing = continuing;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * 베이스볼 숫자 생성
     */
    public void generateBaseBallNumber() {
        // 새 게임일 때만 베이스볼 숫자 생성
        if (isNewGame()) {
            String baseballNumber = numberGenerator.generate();
            System.out.println("숫자 : " + baseballNumber);
            this.baseballNumber = baseballNumber;
        }
    }

    /**
     * 새로운 게임인지 확인
     * @return 새로운 게임이면 true 아니면 false
     */
    public Boolean isNewGame() {
        return isContinuing && isSuccess;
    }

    /**
     * 사용자 입력을 받아 올바른 입력인지 확인
     */
    public void putNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputNumber = InputProcessor.putNumbers();
        while(!validator.validateNumber(inputNumber)){
            System.out.print("잘못 입력하셨습니다. 다시 입력해 주세요 : ");
            inputNumber = InputProcessor.putNumbers();
        }
        this.inputNumber = inputNumber;
    }

    /**
     * 생성된 숫자와 사용자 입력을 비교하여 결과 확인
     */
    public void evaluate() {
        // 결과 확인 후
        EvaluationResult result = evaluator.evaluate(baseballNumber, inputNumber);
        // 메시지 생성하고
        int balls = result.getBalls();
        int strikes = result.getStrikes();
        resultMessage = (strikes > 0 ? strikes + " 스트라이크 " : "")
                + (balls > 0 ? balls + " 볼" : "");
        // 성공여부 확인
        isSuccess = result.isSuccess();
    }

    /**
     * 결과 출력
     */
    public void printResult() {
        System.out.println(resultMessage);
    }

    /**
     * 게임을 계속할지 판단
     */
    public void validateSuccess() {
        if (isSuccess) {
            printSuccessMessage();
            validateToResetGame();
        }
    }

    /**
     * 게임 리셋 여부 판단
     */
    private void validateToResetGame() {
        String input = InputProcessor.putNumbers();
        while(!validator.isValidResetInput(input)){
            System.out.println("잘못 입력했습니다. 다시 입력해 주세요.");
            input = InputProcessor.putNumbers();
        }

        if(input.equals(ConfigConstants.GAME_OVER_FLAG)){
            isContinuing = false;
        }
    }

    /**
     * 성공 메시지 출력
     */
    private void printSuccessMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

