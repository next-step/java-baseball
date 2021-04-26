package enumType;

public enum ErrorType {
    
    // 1000번대 : 사용자 입력 관련 에러
    ERROR_1000_INPUT_DATA_TYPE_ERROR ("숫자만 입력해주세요."),
    ERROR_1010_INPUT_LENGTH_ERROR    ("3자리만 입력해주세요."),
    
    // 2000번대 : 시스템 설정값 관련 에러
    ERROR_2000_NUMBER_LENGTH_ERROR   ("MIN, MAX값의 길이를 확인해주세요."),
    ERROR_2010_DIGIT_LENGTH_ERROR    ("DIGIT값과 MAX/MIN값의 길이가 다릅니다.");
    
    private String errorMessage;
    
    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
}
