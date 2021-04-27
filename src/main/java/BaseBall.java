import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        //스트라이크 3개 이상일시 종료
        while(baseBall.result[0]<3){
            //야구 게임 초기화
            baseBall = baseBall.initResult(baseBall);
            System.out.println("숫자를 입력해주세요.");
            String input = sc.nextLine();
            //예상 정답 배열로 분리
            String[] question = input.split("");
            //결과 확인
            baseBall.result = baseBall.updateResult(baseBall, question);
            //결과 메시지 출력
            baseBall.printTextResult(baseBall.result);
            //게임 종료 여부 확인
            baseBall = baseBall.checkEnd(baseBall, sc);
        }
        sc.close();
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

    //종료 확인
    public BaseBall checkEnd(BaseBall baseBall, Scanner sc){
        if(baseBall.result[0]==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            baseBall = this.continueGame(baseBall, sc);
        }
        return baseBall;
    }

    //종료 명령어 받기
    public BaseBall continueGame(BaseBall baseBall, Scanner sc){
        String exit = sc.nextLine();
        return exit.equals("1") ? this.initBasBall(baseBall) : baseBall;
    }

    //결과값 텍스트 출력
    public void printTextResult(int[] result ){
        String resultText ="";
        if(result[0] >0){
            resultText = result[0]+" 스트라이크 ";
        }
        if(result[1]>0){
            resultText = resultText + result[1]+"볼";
        }
        System.out.println(resultText);
    }

    //결과값 초기화
    public BaseBall initResult(BaseBall baseBall){
        baseBall.result = new int[]{0, 0};
        return baseBall;
    }

    //야구게임 초기화
    public BaseBall initBasBall(BaseBall baseBall){
        baseBall.answer = this.getAnswer();
        baseBall = this.initResult(baseBall);
        return baseBall;
    }
}
