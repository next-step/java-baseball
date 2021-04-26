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
        //예상 답
        String input = "123";
        String[] question = input.split("");
        baseBall.result = baseBall.updateResult(baseBall, question);
        System.out.println(baseBall.answer);
        System.out.println(baseBall.result[0]+" 스트라이크 "+baseBall.result[1]+ " 볼");
    }

    //답안 생성
    public String getAnswer(){
        //숫자 3개 랜덤생성
        List<String> allNumber = new ArrayList<>(9);
        for(int i=1; i<10; i++ ){
            allNumber.add(String.valueOf(i));
        }
        Collections.shuffle(allNumber);
        return (allNumber.get(0) + allNumber.get(1) + allNumber.get(2));
    }


    //스트라이크 볼 판정
    public int[] referee(String answer, int check, int index, int[] result ){
        if(check == index){
            result[0] = result[0]+1;
        }
        if(check != index &&  check > -1){
            result[1] = result[1]+1;
        }
        return result;
    }

    //결과값 반영
    public int[] updateResult(BaseBall baseBall, String[] question){
        for(int i=0; i< question.length; i++){
            int check = baseBall.answer.indexOf(question[i]);
            baseBall.result = this.referee(baseBall.answer,check, i, baseBall.result);
        }
        return baseBall.result;
    }
}
