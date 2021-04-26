package game.baseball;

import game.Game;
import game.baseball.util.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame implements Game {
    final int QUIZ_COUNT = 3;

    @Override
    public void execute(){
        boolean correctAnswer = false;
        ArrayList<Integer> quizList = makeQuiz();
        while(!correctAnswer){
            String input = receiveInput();
            correctAnswer = compareQuizAndInput(quizList,input);
        }
        System.out.println(QUIZ_COUNT+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
        checkRetry();
    }

    public ArrayList<Integer> makeQuiz(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.getRandomNumberList(QUIZ_COUNT);
    }

    public String receiveInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public boolean compareQuizAndInput(ArrayList<Integer> quizList,String input){
        int strikeCount = 0;
        int ballCount = 0;
        String[] inputArray = input.split("");
        for(int i=0; i< inputArray.length;i++){
            strikeCount += checkStrike(quizList,inputArray[i],i);
            ballCount += checkBall(quizList,inputArray[i],i);
        }
        printResult(strikeCount,ballCount);
        return strikeCount == QUIZ_COUNT;
    }

    public int checkStrike(ArrayList<Integer> quizList,String target,int targetOrder){
        int returnValue = 0;
        int targetInt = Integer.parseInt(target);
        if(quizList.indexOf(targetInt)==targetOrder){
            returnValue = 1;
        }
        return returnValue;
    }
    public int checkBall(ArrayList<Integer> quizList,String target,int targetOrder){
        int returnValue = 0;
        int targetInt = Integer.parseInt(target);
        if(quizList.contains(targetInt) && quizList.indexOf(targetInt)!=targetOrder){
            returnValue = 1;
        }
        return returnValue;
    }

    public String printResult(int strikeCount,int ballCount){
        StringBuilder sb = new StringBuilder();
        sb.append(makeResult(strikeCount," 스트라이크 "));
        sb.append(makeResult(ballCount," 볼 "));
        if(strikeCount==0 && ballCount==0){
            sb.append("낫싱");
        }
        System.out.println(sb);
        return sb.toString();
    }
    public String makeResult(int count,String strikeAndBall){
        String result="";
        if(count>0){
            result = count + strikeAndBall;
        }
        return result;
    }
    public void checkRetry(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int retry = scanner.nextInt();
        if (retry == 1){
            execute();
        }
    }
}
