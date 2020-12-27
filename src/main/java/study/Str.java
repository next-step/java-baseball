package study;

public class Str {
    private String value;
    
    public Str(String value) {
        this.value = value;
    }

    public String[] split() {
        return value.split(",");
    }
}