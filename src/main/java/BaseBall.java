import java.util.*;

public class BaseBall {

    /**
     * 1~9의 숫자중 임의의 숫자 3개를 문자로 내보낸다.
     * 1~9가 담긴 리스트에서 랜덤으로 섞은수(shuffle) 앞의 3개를 뽑는다.
     *
     * @return 3자리 임의 숫자(문자)
     */
    public String unique3DigitString() {
        Integer[] arrNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> numbers = new ArrayList<>(Arrays.asList(arrNumbers));
        Collections.shuffle(numbers);

        return numbers.get(0) + "" + numbers.get(1) + "" + numbers.get(2);
    }

    /**
     * 파라미터로 받은 문자가 서로 다른 3자리 숫자 인지 검증한다.
     * 정규표현식 "\\d{3}" 을 만족해야 하며, 문자의 낮개를 set 에 넣었을때 갯수가 3개여야한다.
     *
     * @param input
     * @return
     */
    public boolean checkUnique3DigitString(String input) {
        Set<String> unique = new HashSet<>(Arrays.asList(input.split("")));

        return input.matches("\\d{3}") && unique.size() == 3;
    }

    /**
     * Map 안의 값을 기준으로 결과 메세지를 보여준다
     * @param map
     */
    public void printMsg(Map<String, Integer> map) {
        Integer strike = map.get("STRIKE");
        Integer ball = map.get("BALL");
        StringBuilder msg = new StringBuilder();
        msg.append(strike == 0 ? "" : strike + " 스트라이크 ");
        msg.append(ball == 0 ? "" : ball + " 볼 ");
        msg.append(strike == 0 && ball == 0 ? "낫싱" : "");
        System.out.println(msg.toString());
    }

    /**
     * goal(목표) 수와 source(입력) 수를 가지고 야구게임을 판단한다
     * @param goal
     * @param source
     * @return Map
     */
    public Map<String, Integer> judgeBaseBall(String goal, String source) {
        int strike = checkStrike(goal, source);
        int ball = checkBall(goal, source);

        Map<String, Integer> result = new HashMap<>();
        result.put("STRIKE", strike);
        result.put("BALL", ball);
        return result;
    }

    private int checkStrike(String goal, String source) {
        int result = 0;
        for (int i = 0; i < goal.length(); i++) {
            result += cntStrike(goal.charAt(i), source.charAt(i));
        }
        return result;
    }

    private int cntStrike(char goal, char source) {
        return goal == source ? 1 : 0;
    }

    private int checkBall(String goal, String source) {
        int result = 0;
        for (int i = 0; i < goal.length(); i++) {
            result += cntBall(goal, source.charAt(i), i);
        }
        return result;
    }

    private int cntBall(String goal, char source, int i) {
        int index = goal.indexOf(source);
        return index >= 0 && index != i ? 1 : 0;
    }

}
