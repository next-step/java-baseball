import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BaseBallGame {

    List<String> targetNumberList = new ArrayList<>();
    ArrayList<Integer> numberPool;
    CheckResultModel checkResultModel = new CheckResultModel();
    int isEnd = 0;

    // TODO : 기본 값 생성
    public void init(){
        createNumberPool();
        makeTargetNumberList(3); // 자리수가 바뀔 경우 digit을 변경
    }

    // TODO : 1-9 numberPool 생성
    public void createNumberPool(){
        numberPool = new ArrayList<>();
        for(int i=1; i<10; i++){
            numberPool.add(i);
        }
    }

    // TODO : pool에서 뽑고 지우기 반복 방식
    public String createTargetNumber(int range){
        Random random = new Random();
        int randomIndex = random.nextInt(range);
        int targetNumber = numberPool.get(randomIndex);
        numberPool.remove(randomIndex);
        return Integer.toString(targetNumber);
    }

    // TODO : targetNumberList 생성
    public void makeTargetNumberList(int digit){
        for(int i=0; i<digit; i++){
            int range = numberPool.size() - 1;
            targetNumberList.add(i, createTargetNumber(range));
        }
    }

    // TODO : 유저가 입력한 값을 체크하여 결과 메시지를 생성하고, 게임 종료 여부 반환
    public int checkAnswer(String answer){
        String [] answerArray = answer.split("");
//        System.out.println(answerArray[0] + answerArray[1] + answerArray[2]);
        for(int i=0; i<answerArray.length; i++) {
            checkStrike(answerArray[i], i);
            checkBall(answerArray[i], i);
        }
        makeResultMessage(checkResultModel);
        checkEndGame(checkResultModel);
        return isEnd;
    }

    // TODO : strike 여부 체크하여, checkModel의 strike에 표시
    public void checkStrike(String answerUnit, int unitIndex){
        int targetIndex = targetNumberList.indexOf(answerUnit);
        if(targetIndex == unitIndex){
            checkResultModel.strike++;
        }
    }

    // TODO : ball 여부 체크하여, checkModel의 ball에 표시
    public void checkBall(String answerUnit, int unitIndex){
        int targetIndex = targetNumberList.indexOf(answerUnit);
        if(targetIndex != -1 && targetIndex != unitIndex){
            checkResultModel.ball++;
        }
    }

    // TODO : 게임 결과에 따른 메시지 생성
    public String makeResultMessage(CheckResultModel model){
        StringBuilder stringBuilder = new StringBuilder();
        if(model.strike > 0){
            stringBuilder.append(model.strike + " 스트라이크");
        }
        if(model.ball > 0){
            stringBuilder.append(" " + model.ball + " 볼");
        }
        if(model.strike == 0 && model.ball == 0){
            stringBuilder.append("포볼");
        }
        return stringBuilder.toString();
    }




}
