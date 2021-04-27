package study;

public class Searcher {

    private void checkOneMoreLength(String inputText) {
        if (inputText.length() <= 0) {
            throw new IllegalArgumentException("입력한 문자는 1글자 이상이어야합니다.");
        }
    }

    private void checkFindIndexLength(String inputText, int index) {
        if (0 > index || index >= inputText.length()) {
            new StringIndexOutOfBoundsException("String index out of range: " + index);
        }
    }

    public char findChar(String inputText, int index) {
        checkOneMoreLength(inputText);
        checkFindIndexLength(inputText, index);
        return inputText.charAt(index);
    }


}
