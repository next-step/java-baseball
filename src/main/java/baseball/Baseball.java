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

    /** scanNumber는 게임 중 user의 숫자 추측 입력값을 받는 변수입니다.
     * @return 유저가 입력한 숫자값
     */
    public int scanNumber(){

        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");

        return sc.nextInt();
    }

    /** checkScore는 user가 입력한 숫자에 대한 스코어를 score변수에 저장하는 메서드입니다.
     * score를 초기화 뒤 checkNumber 메서드를 통해 각 자리수에 대한 결과를 반환해 오고, score의 해당 키 값을 증가시킵니다.
     * @param check 유저가 입력한 숫자값.
     */
    public void checkScore(int check){

        score.replace(STRIKE,0);
        score.replace(BALL,0);
        score.replace(MISS,0);
        for (int i=0; i < LEN; i++){
            String replaceKey = checkNumber(LEN - (i+1) , check % TEN);

            score.replace(replaceKey,score.get(replaceKey)+1);
            check = check / TEN;
        }
        return;
    }

    /** checkNumber은 유저가 입력한 값의 자리수와 자리에 따라서 스트라이크인지, 볼인지, 미스인지 판단하는 함수입니다.
     * sameNumber을 통해 해당 숫자가 num에 있는지 확인하고, 위치까지 일치하는지 확인함으로서 판단한다.
     * @param index 유저가 입력한 숫자값의 해당 자릿수.
     * @param number 유저가 입력한 숫자값의 해당 자릿수 숫자값.
     */
    private String checkNumber(int index, int number){

        boolean flag = sameNumber(number);

        if (num[index] == number) {
            return STRIKE;
        }
        if (flag == true) {
            return BALL;
        }
        return MISS;
    }

    /** sameNumber 해당 숫자가 num안에 존재하는지 확인하는 메서드입니다. equalCheck 메서드를 통해 하나라도 같은게 있는지 확인합니다.
     * @param number 유저가 입력한 숫자값의 해당 자릿수 숫자값.
     * @return 값은 존재하면 true 존재하지 않을시 false가 반환됩니다.
     */
    private boolean sameNumber(int number){

        boolean flag = false;

        for (int i = 0; i < LEN; i++){
            flag = equalCheck(num[i],number,flag);
        }
        return flag;
    }

    /** equalCheck는 sameNumber의 부속 메서드입니다.
     * @param number1 비교할 숫자1
     * @param number2 비교할 숫자2
     * @param flag  이전에 이미 같은 숫자가 있었는지 여
     * @return 이미 이전에 같은 숫자였을 경우 true 해당사항이 없으면 false를 반환합니다.
     */
    private boolean equalCheck(int number1, int number2, boolean flag){
        if (number1 == number2 || flag == true) {
            return true;
        }
        return false;
    }

    /** printScore는 연산된 스코어를 출력하기 위한 메서드입니다.
     * 문장은 낫싱의 경우를 제외하고는 printer 변수를 통해 구성되며 printStrikeBall을 통해 전체적인 문장을 구성합니다.
     * @return 결과적으로 출력될 문장.
     */
    public String printScore(){

        String printer = "";

        if (score.get(MISS) == LEN){
            System.out.println(NOTTING);
            return NOTTING;
        }
        printer = printStrikeBall(STRIKE, printer);
        printer = printStrikeBall(BALL, printer);
        System.out.println(printer);
        return printer;
    }

    /** printStrikeBall 문장을 만들기 위한 메서드입니다,
     * @param count 스트라이크와 볼 같은, 구성 종류에 관한 String
     * @param printer  지금까지 쓰여진 문장.
     * @return 문장을 추가하여 반환합니다.
     */
    private String printStrikeBall(String count, String printer){

        if (score.get(count) == 0){
            return printer;
        }
        if (printer != ""){
            printer += " ";
        }
        return printer + Integer.toString(score.get(count)) + " " + count;
    }

    /** checkRestart은 게임이 완료되었는지 확인하기 위한 메서드입니다,
     * @return 3스트라이크면 true 아니면 false를 반환합니다.
     */
    public boolean checkRestart(){

        if (score.get(STRIKE) != LEN){
            return true;
        }
        return false;
    }

    /** restartSwitch는 게임 재시작 여부를 확인하기 위한 메서드입니다.
     * 본래 checkRestart와 합쳐져 있었으나, checkRestart의 정상 작동 확인을 위해 분리하였습니다.
     * 이유는 중도 입력에 대한 테스트 구성 방법을 모르기 때문입니다. restart()를 통해 게임 완료시 재시작 여부를 받아와서 반환합니다.
     * @param flag checkRestart에서 3스트라이크 여부를 받아온 값입니다.
     * @return 게임 완료가 아니거나, 재시작시 true를 반환하고 게임을 끝내도록 입력이 들어왔을 경우 false를 반환합니다.
     */
    public boolean restartSwitch(boolean flag){

        if (flag==false){
            return restart();
        }
        return true;
    }

    /** restart는 게임 재시작 여부를 묻기 위한 메서드입니다.
     * 재시작 문구를 주고 입력에 따라서 재시작 여부를 반환합니다. 재시작시, makeNumber을 통해 num을 새로생성합니다.
     * @return 게임 재시작 키인 RESTARTNUM값일 경우 true, 아닐경우 false를 반환합니다.
     */
    private boolean restart(){

        Scanner sc = new Scanner(System.in);

        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (sc.nextInt() == RESTARTNUM) {
            makeNumber();               /* 재시작 시에는 게임 숫자를 다시 만들어준다. */
            return true;
        }
        return false;
    }


}
