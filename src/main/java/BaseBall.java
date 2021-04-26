import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseBall {
    private int[] result={0,0}; // result[0] strike, result[1] ball
    private String answer; // 컴퓨터의 정답

    public int[] getResult(){
        return this.result;
    }

    public String answer(){
        return this.answer;
    }

    public static void main(String[] args){
        BaseBall baseBall = new BaseBall();
        //랜덤 정답 생성
        baseBall.answer = baseBall.getAnswer();

        System.out.println(baseBall.answer);
    }

    //답안 생성
    public String getAnswer(){
        //숫자 3개 랜덤생성
        List<String> allNumber = new ArrayList<String>(9);
        for(int i=1; i<10; i++ ){
            allNumber.add(String.valueOf(i));
        }
        Collections.shuffle(allNumber);
        return (allNumber.get(0) + allNumber.get(1) + allNumber.get(2));
    }

}
