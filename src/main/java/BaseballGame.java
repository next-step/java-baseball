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
        String inputNumber = InputProcessor.putNumbers();
        while(!validator.validateNumber(inputNumber)){
            inputNumber = InputProcessor.putNumbers();
        }
        this.inputNumber = inputNumber;
    }

    /**
     * 생성된 숫자와 사용자 입력을 비교하여 결과 확인
     */
    public void evaluate() {
        // 검사
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {









        }



        // isSuccess
        // 메시지




    }
}
