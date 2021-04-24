package enumType;

public enum ErrorType {
    
    // 1000번대 : 기능별로 에러 메세지 구분해볼 것.
    // 2000번대 : 
    // 3000번대 : 
    // ..
    ERROR_1000_SAMPLE("1000", "기능 a에 대한 1000번 에러 내용"),
    ERROR_1010_SAMPLE("1010", "기능 a에 대한 1010번 에러 내용"),
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
