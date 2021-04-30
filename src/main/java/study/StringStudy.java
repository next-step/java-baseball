package study;

public class StringStudy {
    public static String removeBracket(String inputText) throws IllegalArgumentException {
        if(inputText == null || inputText.indexOf("(") < 0 || inputText.indexOf(")") < 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        };

        return inputText.substring(inputText.indexOf("(")+1).substring(0,inputText.indexOf(")")-1);
    }
}
