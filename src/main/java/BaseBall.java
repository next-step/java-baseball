import java.util.*;

public class BaseBall {

    private final Integer FINISH_STRIKE_NUMBER = 3;
    private final Integer GAME_CONTINUE = 1;

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
     * Map 안의 값을 기준으로 결과 메세지를 보여준다
     *
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
     *
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

    /**
     * strike 갯수로 종료가 되었는지 판단한다
     *
     * @param strike
     * @return
     */
    public boolean judgeFinish(Integer strike) {
        if (FINISH_STRIKE_NUMBER.equals(strike)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
        return false;
    }

    /**
     * 종료된 경우 새로운 게임을 할지, 끝낼지 입력을 받아 결정한다
     *
     * @param finish
     * @return
     */
    public boolean continueOrBreak(boolean finish) {
        if (!finish) {
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer cob = scanner.nextInt();

        return GAME_CONTINUE.equals(cob);
    }

    /**
     * 재시작을 선택한 경우 새로운 goal 을 반환한다
     *
     * @param restart
     * @param goal
     * @return
     */
    public String resetGoal(boolean restart, String goal) {
        return restart ? unique3DigitString() : goal;
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
