package domain;

public enum BaseballType {
    STRIKE("스트라이크"),BALL("볼"),NOTHING("낫싱");

    private final String type;

    public String getType(){
        return type;
    }

     BaseballType(String type){
        this.type = type;
    }


}

