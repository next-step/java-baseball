package enumType;

public enum SystemNumberType {
    
     MIN  ("MIN"  , 100, "랜덤으로 생성되는 난수 중 가장 작은 수")
    ,MAX  ("MAX"  , 999, "랜덤으로 생성되는 난수 중 가장 큰 수")
    
    ,DIGIT("DIGIT", 3  , "자리수")
    
    ,START("START", 1  , "게임 시작")
    ,END  ("END"  , 2  , "게임 종료");
    
    private String name;
    private int    number;
    private String description;
    
    SystemNumberType(String name, int number, String description) {
        this.name        = name;
        this.number      = number;
        this.description = description;
    }
    
    public int getNumber() {
        return number;
    }
}
