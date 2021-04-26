package enumType;

public enum UmpireType {
    
     STRIKE  ("스트라이크")
    ,BALL    ("볼")
    ,NOTHING ("낫싱");
    
    private String decision;

    UmpireType(String decision) {
        this.decision = decision;
    }

    public String getDecision() {
        return decision;
    }
}
