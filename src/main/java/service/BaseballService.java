package service;

import domain.baseball.Baseball;
import domain.baseball.BaseballGroup;
import domain.player.Computer;
import domain.player.User;
import util.BaseballGenerate;
import view.UserInput;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    private static Computer computer;
    private static User user;

    private static int strike;
    private static int ball;

    public static void isSetInfo(){
        strike = 0;
        ball = 0;
        user = null;
        computer = null;
    }

    private void isResetBallCount(){
        strike = 0;
        ball = 0;
    }

    public static int getBall() {
        return ball;
    }

    public static int getStrike() {
        return strike;
    }

    public void baseballGameStart(){

        isSetInfo();

        //Computer baseball generate
        baseballNumberComputerInit();

        //User Input Game Play
        baseballUserGamePlay();

        //종료 여부
        baseballGameWhetherToStart();
    }


    private void baseballUserGamePlay(){

        while (!isStrikeGameEnd()){
            isResetBallCount();

            //User baseball Input init
            baseballNumberUserInit();

            //매칭된 내역이 있는지 체크
            baseballNumberMatching();
        }
    }

    private void baseballNumberComputerInit(){
        // 이미 생성된 Random 값이 있다면 재 할당 하지 않는다.
        if(null == computer || computer.getBaseballList().size() == 0){
            // 게임을 위한 숫자 3개 생성
            BaseballGroup baseballGroup = BaseballGenerate.createBaseballGroup();

            // 컴퓨터에 해당 숫자 객체를 담음
            computer = new Computer(baseballGroup);
        }
    }

    private void baseballNumberUserInit(){
        List<Baseball> userInputBaseballList = new ArrayList<>();
        // 사용자에게 메시지 노출 및 기입 받음
        String[] userInputBaseballNumbers = UserInput.baseballMatchingNumberMessage();

        for(String userInputNumber : userInputBaseballNumbers){
            userInputBaseballList.add(BaseballGenerate.createBaseballValue(Long.valueOf(userInputNumber)));
        }

        BaseballGroup userInputBaseballGroup = new BaseballGroup(userInputBaseballList);

        // 사용자가 기입한 숫자 객체에 담음
        user = new User(userInputBaseballGroup);
    }

    // matching counting 시작 메소드
    private void baseballNumberMatching(){

        for(int i =0; i<user.getBaseballList().size(); i++){
            Baseball userInputBaseball = user.getBaseballList().get(i);
            Baseball computerRandomBaseball = computer.getBaseballList().get(i);
            isCountingGameResult(userInputBaseball,computerRandomBaseball,computer.getBaseballList());
        }

        countingStrikeAndBallMessage();
    }

    // 넘어온 값으로 strike && ball을 counting 하는 역할을 담당.
    public static void isCountingGameResult(Baseball userInputBaseball, Baseball computerRandomBaseball, List<Baseball> computerBaseballList){
        if(!isStrikeCheck(userInputBaseball,computerRandomBaseball)){
            isBallCheck(userInputBaseball,computerBaseballList);
        }
    }


    // Strike 여부 확인
    public static boolean isStrikeCheck(Baseball userInputBaseball ,Baseball computerRandomBaseball){
        boolean checkStrike = false;

        if(userInputBaseball.equals(computerRandomBaseball)){
            checkStrike = true;
            strike++;
        }

        return checkStrike;
    }


    // Ball 여부 확인
    public static boolean isBallCheck(Baseball userInputBaseball ,List<Baseball> computerBaseballList){
        boolean checkBall = false;

        if(computerBaseballList.contains(userInputBaseball)){
            checkBall = true;
            ball++;
        }

        return checkBall;
    }


    private void countingStrikeAndBallMessage(){
        if(!isStrikeGameEnd()){
            System.out.println(UserInput.baseballMatchingCount(strike,ball));
        }
    }

    private boolean isStrikeGameEnd(){
        boolean checkEndGame = false;

        if(strike == BaseballGroup.getRandomLength()){
            checkEndGame = true;
        }

        return checkEndGame;
    }

    // 재시작 여부를 받아, 새로이 시작 가능하도록 제어
    private void baseballGameWhetherToStart(){
        if(UserInput.baseballGameOverAndReStartGame()){
            baseballGameStart();
        }
    }
}
