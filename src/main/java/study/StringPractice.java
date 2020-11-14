package study;

public class StringPractice {

    /**
     * [요구사항 1]
     * 1) "1,2"을 "1"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * 2) "1,2"을 "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    public String[] divideComma(java.lang.String text){
        String[] result = text.split(",");
        return result;
    }

    /**
     * [요구사항 2]
     * 1) "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 하도록 구현한다. ()을 제거하고 "1,2"를 반환
     */
    public String removeParenthesis(java.lang.String text){
        String result = text.substring(1,text.lastIndexOf(")"));
        return result;
    }

    /**
     * [요구사항 3]
     * 1) "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.     *
     * 2) String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한
     *    학습 테스트를 구현한다.
     * 3) JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */

    public char getFindChar(int index){
        String text = "abc";
        char ch = text.charAt(index);
        return ch;
    }







}
