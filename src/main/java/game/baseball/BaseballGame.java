package game.baseball;

import game.Game;
import game.baseball.util.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame implements Game {
    final int QUIZ_COUNT = 3;

    @Override
    public void excute(){
        boolean correctAnswer = false;
        ArrayList<Integer> quizList = makeQuiz();
        while(!correctAnswer){
            String input = receiveInput();
            correctAnswer = compareQuizAndInput(quizList,input);
        }
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
        boolean correctAnswer = false;
        String[] inputArray = input.split("");
        for(int i=0; i< inputArray.length;i++){
            strikeCount += checkStrike(quizList,inputArray[i],i);
            ballCount += checkBall(quizList,inputArray[i],i);
        }
        printCompareResult(strikeCount,ballCount);
        if (strikeCount==3){
            correctAnswer = true;
        }
        return correctAnswer;
    }

    public int checkStrike(ArrayList<Integer> quizList,String target,int targetOrder){
        int returnValue = 0;

        if(quizList.indexOf(Integer.parseInt(target))==targetOrder){
            returnValue = 1;
        }
        return returnValue;
    }
    public int checkBall(ArrayList<Integer> quizList,String target,int targetOrder){
        int returnValue = 0;
        if(quizList.contains(Integer.parseInt(target)) && quizList.indexOf(Integer.parseInt(target))!=targetOrder){
            returnValue = 1;
        }
        return returnValue;
    }

    public String printCompareResult(int strikeCount,int ballCount){
        String result = "";
        if(strikeCount>0){
            result += strikeCount + " 스트라이크 ";
        }
        if(ballCount>0){
            result += ballCount + " 볼 ";
        }
        if(strikeCount==0 && ballCount==0){
            result += "낫싱";
        }
        System.out.println(result);
        return result;
    }

    public void checkRetry(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int retry = scanner.nextInt();
        if (retry == 1){
            excute();
        }
    }
}
