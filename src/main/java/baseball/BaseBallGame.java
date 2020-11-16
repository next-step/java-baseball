package baseball;

import java.util.*;

/**
 * 숫자 야구 게임 로직 클래스
 *  - 메서드 레벨로 분리
 */
public class BaseBallGame {

    /* 게임 Rule */
    private static final Integer BASE_BALL_CNT = 3;
    private static final Integer BASE_BALL_MIN_POINT = 1;
    private static final Integer BASE_BALL_MAX_POINT = 9;
    private static final Integer THREE_STRIKE_CNT = 3;

    private static final Integer ZERO = 0;

    /* 재게임 여부 값 */
    private static final String END_GAME = "2";
    private static final String RE_GAME = "1";

    /* Message */
    private static final String MSG_USER_TURN_THREE_NUMBER = "3개의 숫자를 입력해 주세요 : ";
    private static final String MSG_END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String MSG_RE_GAME = "게임을 새로 시작하려면 " + RE_GAME + ", 종료하려면 " + END_GAME + "를 입력하세요.\n";
    /* 비교 값 출력 */
    private static final String MSG_STRIKE = " 스트라이크 ";
    private static final String MSG_BALL = " 볼";
    private static final String MSG_NOTHING = "낫싱";

    /**
     * [Game Logic] 게임 로직 startGame()
     *  1. 컴퓨터 턴: getComBalls()
     *  2. 사용자 턴: getUserBall()
     *  3. 재게임 선택 여부: isReGame()
     */
    public void startGame(Scanner sc) {
        do {
            /* 컴퓨터 턴 */
            List<Integer> comBall = getComBalls();

            /* 사용자 턴 */
            getUserBall(sc, comBall);

            /* 게임 재시작 여부 확인 */
        } while(isReGame(sc));
    }

    /**
     * [Computer] 1 ~ 9까지 서로 다른 3개의 숫자를 생성하는 메서드
     *  1. 1 ~ 9까지 범위 숫자를 생성
     *  2. 서로 다른 숫자를 생성
     *  3. 총 3개의 숫자를 저장
     *
     * @return 생성된 숫자를 LinkedList 변환하여 반환
     */
    public List<Integer> getComBalls() {

        Random ran = new Random();
        ran.setSeed(System.currentTimeMillis());

        Set<Integer> comNums = new LinkedHashSet<>();
        while(comNums.size() < BASE_BALL_CNT) {
            int randomNumbers = ran.nextInt(BASE_BALL_MAX_POINT) + BASE_BALL_MIN_POINT;
            comNums.add(randomNumbers);
        }
        return new LinkedList<>(comNums);
    }

    /**
     * [Player] 게임 플레이어
     *  1. 게임 플레이어는 컴퓨터가 생각하는 1 ~ 9까지 3개의 숫자를 입력
     *  2. 컴퓨터가 생성한 3개의 숫자와 게임 플레이어가 만든 3개의 숫자를 비교
     *  3. 게임 플레이어가 입력한 값이 컴퓨터가 입력한 값과 순서와 3개의 숫자가 모두 같은 경우 3 Strike 로 반복 종료
     *
     * @param sc 사용자의 입력을 받을 수 있는 Scanner
     * @param comBall 컴퓨터가 생성한 1 ~ 9까지 서로 다른 3개의 숫자
     */
    private void getUserBall(Scanner sc, List<Integer> comBall) {
        boolean strikeFlag = true;
        while(strikeFlag) {
            int[] userBall = selectBalls(sc);
            strikeFlag = isMatches(userBall, comBall);
        }
        /* 3스트라이크 인 경우 게임 종료 메시지 전송 */
        print(MSG_END_GAME);
    }

    /**
     * [Game Logic] 컴퓨터와 게임 플레이어의 값을 비교
     *  1. 컴퓨터가 입력한 값과 사용자가 입력한 값들의 순서와 값이 모두 같은 경우 Strike Count 증가
     *  2. 순서는 같지 않으나 값을 포함하고 있는 경우 Ball Count 증가
     *
     * @param userBall 사용자가 입력한 1 ~ 9까지 3개의 숫자
     * @param comBall 컴퓨터가 생성한 1 ~ 9까지 서로 다른 3개의 숫자
     * @return 3스트라이크인 경우 false, 그 외에는 true 를 반환
     */
    public boolean isMatches(int[] userBall, List<Integer> comBall) {
        int ballCnt = ZERO;
        int strikeCnt = ZERO;
        for(int i = 0 ; i < userBall.length ; i++) {
            /* 스트라이크 체크 */
            if(comBall.get(i) == userBall[i]) {
                strikeCnt++;
                continue;
            }
            /* 볼 체크 */
            if(comBall.contains(userBall[i])) {
                ballCnt++;
            }
        }
        return printMatches(strikeCnt, ballCnt);
    }

    /**
     * [Game Logic] 한 회의 게임이 종료된 후, 재게임 또는 게임종료 여부를 입력 요청하는 메서드
     *  1. 한 회 게임이 끝난 뒤 재게임 여부를 요청
     *  2. 사용자는 1 또는 2의 값으로 재게임 또는 종료를 선택할 수 있다.
     *
     * @param sc 사용자의 입력을 받을 수 있는 Scanner
     * @return 게임 Rule에 따라 재게임: 1 입력 시 true, 게임 종료: 2 입력 시: false
     */
    private boolean isReGame(Scanner sc) {
        String reGameFlag;
        do {
            print(MSG_RE_GAME);
            reGameFlag = sc.nextLine();
            /* 사용자가 입력한 값이 숫자가 아니거나, 1 또는 2가 아닌 경우 다시 입력 */
        } while(!isReGame(reGameFlag));

        return reGameFlag.equals(RE_GAME);
    }

    /* 컴퓨터와 사용자의 값을 비교하여 스트라이크, 볼, 낫싱을 출력 */
    public boolean printMatches(int strikeCnt, int ballCnt) {
        StringBuilder sb = new StringBuilder();
        if(strikeCnt == THREE_STRIKE_CNT) {
            sb.append(strikeCnt).append(MSG_STRIKE);
            print(sb.toString() + "\n");
            return false;
        }
        if (strikeCnt > ZERO) {
            sb.append(strikeCnt).append(MSG_STRIKE);
        }
        if (ballCnt > ZERO) {
            sb.append(ballCnt).append(MSG_BALL);
        }
        if (strikeCnt == ZERO && ballCnt == ZERO) {
            sb.append(MSG_NOTHING);
        }
        print(sb.toString() + "\n");
        return true;
    }

    /* 게임 플레이어 */
    public int[] selectBalls(Scanner sc) {
        String userNumbers;
        do {
            print(MSG_USER_TURN_THREE_NUMBER);
            userNumbers = sc.nextLine();
            /* 사용자의 입력 값이 1 ~ 9까지 숫자이면서 길이가 3이 아닌경우 다시 입력 */
        } while (!isUserInputValidLength(userNumbers) ||
                !isInteger(userNumbers) ||
                !isNumberOneBetweenNine(userNumbers));

        /* 정상 입력 시 정수형 배열로 casting */
        return castStringToInt(userNumbers);
    }

    /* 컴퓨터가 생성한 값의 범위가 1 ~ 9까지인지 확인 */
    public boolean isNumberOneBetweenNine(String userNumbers) {
        int[] userInputList = castStringToInt(userNumbers);
        for(Integer item : userInputList) {
            /* 1 ~ 9 범위의 값이 아닌경우 false 리턴 */
            if(!(BASE_BALL_MIN_POINT <= item && BASE_BALL_MAX_POINT >= item)) {
                return false;
            }
        }
        return true;
    }

    /* 입력 길이가 3인지 확인 */
    public boolean isUserInputValidLength(String userNumbers) {
        int userInputValueLength = userNumbers.length();
        return userInputValueLength == BASE_BALL_CNT;
    }

    /* 게임플레이어가 입력한 값이 숫자로 캐스팅이되는지 확인 */
    public boolean isInteger(String userNumbers) {
        try {
            Integer.parseInt(userNumbers);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /* 숫자로 변롼이 가능한 문자열을 정수형 배열로 반환 */
    public int[] castStringToInt(String userNumbers) {
        int[] tmp = new int[userNumbers.length()];
        for(int i = 0 ; i < userNumbers.length() ; i++) {
            tmp[i] = userNumbers.charAt(i) - '0';
        }
        return tmp;
    }

    /* 재게임 여부 1 또는 2 */
    public boolean isReGame(String reGameFlag) {
        return (reGameFlag.equals(END_GAME) || reGameFlag.equals(RE_GAME));
    }

    /* 메시지 출력*/
    private void print(String msg) {
        System.out.print(msg);
    }
}
