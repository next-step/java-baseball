public class AnswerTester {
    public String answer = "";
    public AnswerTester(String answer){
        this.answer = answer;
    }
    public int[] getResult(String tryString){
        int[] result = new int[]{
                getBallCount(tryString),
                getStrikeCount(tryString)
        };
        return result;
    }
    int getStrikeCount(String tryString){
        int result = 0;
        for (int i = 0; i < tryString.length(); i++) {
            result += answer.charAt(i) == tryString.charAt(i) ? 1 : 0;
        }
        return result;
    }
    int getBallCount(String tryString){
        int result = 0;
        for (int i = 0; i < tryString.length(); i++) {
            result += (answer.charAt(i) != tryString.charAt(i) &&
                        answer.contains(tryString.charAt(i) + "")) ? 1 : 0;
        }
        return result;
    }
}
