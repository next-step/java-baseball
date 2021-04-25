package baseball.domain;

public class BaseBallComputer {
    private String comNum = "";

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
}
