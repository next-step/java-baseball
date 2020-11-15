package baseball;

import java.util.*;

/**
 * 숫자 야구 게임 로직 클래스
 */
public class BaseBallGame {

    private static final Integer BASE_BALL_CNT = 3;
    private static final Integer BASE_BALL_MIN_POINT = 1;
    private static final Integer BASE_BALL_MAX_POINT = 9;

    /**
     * [Game Logic] 게임 로직 startGame()
     *  1. 컴퓨터 턴: comTurn()
     *  2. 사용자 턴: userTurn()
     *  3. 재게임 선택 여부: questionGame()
     */
    public void startGame(Scanner sc) {
        do {
            /* 컴퓨터 턴 */
            List<Integer> comBall = comTurn();

            /* 사용자 턴 */
            userTurn(sc, comBall);

            /* 게임 재시작 여부 확인 */
        } while(isReGame(sc));
    }

    /**
     * [COMPUTER] 1 ~ 9까지 서로 다른 3개의 숫자를 생성하는 메서드
     *  1. 1 ~ 9까지 범위 숫자를 생성
     *  2. 서로 다른 숫자를 생성
     *  3. 총 3개의 숫자를 저장
     *
     * @return 생성된 숫자를 LinkedList 변환하여 반환
     */
    public List<Integer> comTurn() {

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
     * [PLAYER] 게임 플레이어
     *  1. 게임 플레이어는 컴퓨터가 생각하는 1 ~ 9까지 3개의 숫자를 입력
     *  2. 컴퓨터가 생성한 3개의 숫자와 게임 플레이어가 만든 3개의 숫자를 비교
     *  3. 게임 플레이어가 입력한 값이 컴퓨터가 입력한 값과 순서와 3개의 숫자가 모두 같은 경우 3 Strike 로 반복 종료
     *
     * @param sc 사용자의 입력을 받을 수 있는 Scanner
     * @param comBall 컴퓨터가 생성한 1 ~ 9까지 서로 다른 3개의 숫자
     */
    private void userTurn(Scanner sc, List<Integer> comBall) {

        boolean strikeFlag = true;
        while(strikeFlag) {
            int[] userBall = selectBalls(sc);

            strikeFlag = isMatches(userBall, comBall);
        }
    }

    public boolean isMatches(int[] userBall, List<Integer> comBall) {
        return false;
    }

    /* 게임 플레이어 */
    public int[] selectBalls(Scanner sc) {
        String userNumbers = "";
        do {
            System.out.print("3개의 숫자를 입력해 주세요 : ");;
            userNumbers = sc.nextLine();
            /* 사용자의 입력 값이 1 ~ 9까지 숫자이면서 길이가 3이 아닌경우 다시 입력 */
        } while (!isValidLength(userNumbers) ||
                !isInteger(userNumbers) ||
                !isNumberOneBetweenNine(userNumbers));

        /* 정상 입력 시 정수형 배열로 casting */
        return castStringToInt(userNumbers);
    }

    /* 컴퓨터가 생성한 값의 범위가 1 ~ 9까지인지 확인 */
    public boolean isNumberOneBetweenNine(String userInput) {
        int[] userInputList = castStringToInt(userInput);
        for(Integer item : userInputList) {
            /* 1 ~ 9 범위의 값이 아닌경우 false 리턴 */
            if(!(BASE_BALL_MIN_POINT <= item && BASE_BALL_MAX_POINT >= item)) {
                return false;
            }
        }
        return true;
    }

    /* 입력 길이가 3인지 확인 */
    public boolean isValidLength(String userInput) {
        int len = userInput.length();
        if(len != BASE_BALL_CNT) {
            return false;
        }
        return true;
    }

    /* 게임플레이어가 입력한 값이 숫자로 캐스팅이되는지 확인 */
    public boolean isInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
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

    /**
     * [Game Logic] 한 회의 게임이 종료된 후, 재게임 또는 게임종료 여부를 입력 요청하는 메서드
     *  1. 사용자의
     * @param sc 사용자의 입력을 받을 수 있는 Scanner
     * @return 게임 Rule에 따라 재게임: 1 입력 시 true, 게임 종료: 2 입력 시: false
     */
    private boolean isReGame(Scanner sc) {
        return false;
    }
}
