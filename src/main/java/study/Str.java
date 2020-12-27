package study;

public class Str {
    private String value;
    
    public Str(String value) {
        this.value = value;
    }

    public String removeParenthesis() {
        return value.substring(1, value.length() - 1);
    }

    public String[] split() {
        return value.split(",");
    }

    public char charAt(int index) {
        return value.charAt(index);
    }
}