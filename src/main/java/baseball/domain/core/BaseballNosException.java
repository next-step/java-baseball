package baseball.domain.core;

public final class BaseballNosException extends RuntimeException {
    public static final String ERROR_MSG_NOTCORRECT_BASEBALLNOS = "문자열 중에 잘못된 문자가 존재합니다.";
    public static final String ERROR_MSG_DUPLICATE_BASEBALLNOS = "문자열 중에 중복된 내용이 존재합니다.";
    private BaseballNosException(String message) {
        super(message);
    }

    public static BaseballNosException newNotCorrectBaseballNosException(){
        return new BaseballNosException(ERROR_MSG_NOTCORRECT_BASEBALLNOS);
    }

    public static BaseballNosException newDuplicateBaseballNosException(){
        return new BaseballNosException(ERROR_MSG_DUPLICATE_BASEBALLNOS);
    }



}
