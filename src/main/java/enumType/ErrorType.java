package enumType;

public enum ErrorType {
    
    // 1000번대 : 사용자 입력 관련 에러
    // 2000번대 : 기능별로 에러 메세지 구분해볼 것.
    // 3000번대 : 
    // ..
    ERROR_1000_INPUT_DATA_TYPE_ERROR ("1000", "숫자만 입력해주세요."),
    ERROR_1010_INPUT_LENGTH_ERROR    ("1010", "3자리만 입력해주세요."),
    ERROR_2000_SAMPLE("2000", "기능 b에 대한 2000번 에러 내용");
    
    private String errorCode;
    private String errorMessage;
    
    ErrorType(String errorCode, String errorMessage) {
        this.errorCode    = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
}
