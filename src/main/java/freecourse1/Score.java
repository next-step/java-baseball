package freecourse1;

public class Score {

    private static final int SIZE = 3;
    private int strike = 0;
    private int ball = 0;
    private String sMessage;

    public Score() { }

    public String getScore(){
        return sMessage;
    }
    
    public void compare(int[] randomNumbers, int[] gamerNumbers){
        compareNumbers(randomNumbers,gamerNumbers);
        makeMessage();
    }

    private void compareNumbers(int[] randomNumbers, int[] gamerNumbers){
        strike = 0;
        ball = 0;
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                if(randomNumbers[i] == gamerNumbers[j]){
                    if(i == j){
                        strike++;
                    }else{
                        ball++;
                    }
                }
            }
        }
    }

    private String makeMessage(){
        sMessage = new String();
        if(strike == 0 && ball == 0)
            sMessage = sMessage.concat("낫싱");
        if(strike > 0)
            sMessage = sMessage.concat(strike + "스트라이크 ");
        if(ball > 0)
            sMessage = sMessage.concat(ball + "볼 ");
        return sMessage;
    }

}
