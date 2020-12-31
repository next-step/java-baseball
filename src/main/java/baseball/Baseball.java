/*
 * Baseball.java 2020-12-31
 *
 * ver 1.0
 *
 * hendo.park(GitHub : Chaeoon-Park)의 코드입니다.
 *
 */

package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Baseball 클래스는 숫자야구 게임을 위해 만들어진 클래스이다. 로직의 작동은 Main Class에서 이루어진다.
 *
 * @version         1.00 2020년 12월 31일
 * @author          hendo.park
 */

class Baseball{
    /* Baseball 클래스의 메서드는 크게 생성자,난수 생성부,스코어 확인,입출력,재시작 확인부로 나누어진다 */

    /** LEN~NOTTING은 클래스 내에서 사용될 상수값에 대해 나타내고있다. 변수 이름과 값이 매칭된다. */
    private static final int LEN = 3;
    private static final int TEN = 10;
    private static final int RESTARTNUM = 1;
    private static final int RANDNUM = 10000;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String MISS = "미스";
    private static final String NOTTING = "낫싱";

    /** num은 게임 상에서 컴퓨터가 알고 있는 생성된 난수값을 자리수별로 배열로 입력하였다. */
    private int[] num = new int[3];

    /** score은 플레이어가 숫자를 입력하였을 때 스코어를 저장하기 위한 HashMap이다. */
    private HashMap<String,Integer> score = new HashMap<String,Integer>(){{
        put(STRIKE,0);
        put(BALL,0);
        put(MISS,0);
    }};

    /** 생성자 Baseball은 우선 num을 초기화 한 뒤, makeNumber 메서드를 통해 num 난수값을 생성하는 역할을 한다 */
    public Baseball(){

        for (int i = 0; i < LEN; i++) {
            num[i] = 0;
        }
        makeNumber();
    }

    /**
     * makeNumber은 난수 생성부로, 0~9의 숫자를 담은 ArrayList에서 숫자를 하나 선택 한 뒤, 그 숫자를 ArrayList에서 지우고,
     * 남은 숫자중에 다시 한번 숫자를 뽑는 과정을 숫자의 길이만큼 반복할 수 있도록 합니다.
     */
    private void makeNumber(){

        ArrayList<Integer> numList = new ArrayList<Integer>();

        for (int i = 0; i < TEN; i++){
            numList.add(i);
        }
        for (int i = 0; i < LEN; i++){
            int randIndex = (int)((Math.random()*RANDNUM)%numList.size());

            num[i] = numList.get(randIndex);
            numList.remove(randIndex);
        }
        return;
    }
    /** testNumber은 private 변수인 num에 접근하기 위한 메서드입니다. */
    public int[] testNumber(){
        return num;
    }

    /** testScore private 변수인 num에 testNum을 넣어 해당 숫자로 바꾸기 위한 메서드입니다.
     * @param testNum 테스트를 위해 입력된  값.
     */
    public void testScore(int testNum){

        for (int i = 0; i < LEN; i++){
            num[(LEN-1) - i] = testNum%10;
            testNum = testNum/10;
        }

    }
}
