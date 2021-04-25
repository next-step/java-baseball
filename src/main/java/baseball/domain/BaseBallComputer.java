package baseball.domain;

public class BaseBallComputer {
    private String comNum = "";
    private int strike = 0;
    private int ball = 0;

    public String getComputerCreateNum(){
        return comNum;
    }

    protected void computerCreateNum(){
        while(comNum.length() < 3){
            String number = (int) (Math.random() * 9) + 1+"";
            if(!comNum.contains(number)){
                comNum += number;
            }
        }
    }

    protected boolean game(String computerBaseNum, String userBaseNum){
        String[] arrCom = computerBaseNum.split("");
        String[] arrUser = userBaseNum.split("");
        for(int i=0; i<arrCom.length; i++){
            strike(arrCom[i], arrUser[i]);
            ball(arrCom, arrUser[i], i);
        }
        gameResult();
        return gameOver();
    }

    private void strike(String arrCom, String arrUser){
        if(arrCom.equals(arrUser)){
            strike++;
        }
    }

    private void ball(String[] arrCom, String arrUser, int idx){
        for(int i=0; i<arrCom.length; i++){
            if(arrCom[i].equals(arrUser) && i==idx){
                continue;
            }else if(arrCom[i].equals(arrUser) && i!=idx){
                ball++;
            }
        }
    }

    private void gameResult(){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }else if(strike > 0 && ball == 0){
            System.out.println(strike + " 스트라이크");
        }else if(strike == 0 && ball > 0){
            System.out.println(ball + " 볼");
        }else if(strike > 0 && ball > 0){
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }
    }

    private boolean gameOver(){
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            reset();
            return false;
        }
        reset();
        return true;
    }

    private void reset(){
        ball = 0;
        strike = 0;
        comNum = "";
    }
}
