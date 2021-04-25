package game.baseball.util.generator;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberGenerator {
/*
 * getRandomNumber - 랜덤 숫자 생성(1~9까지의 랜덤 숫자 생성)
 * getRandomNumberList - 사이즈에 맞는 랜덤 숫자 배열 생성
 * addNumberIntoList - 리스트에 숫자 추가
 * checkDuplication - 중복 체크
 */
    final int MAX_VALUE = 9;
    final int MIN_VALUE = 1;

    public int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(MAX_VALUE)+MIN_VALUE;
    }
    public ArrayList<Integer> getRandomNumberList(int size){
        ArrayList<Integer> randomNumberList = new ArrayList<>();
        while(randomNumberList.size()!=size){
            addNumberIntoList(randomNumberList,getRandomNumber());
        }
        return randomNumberList;
    }
    public void addNumberIntoList(ArrayList<Integer> list, int randomNumber){
        boolean duplicationStatus = checkDuplication(list,randomNumber);
        if(!duplicationStatus){
            list.add(randomNumber);
        }
    }
    public boolean checkDuplication(ArrayList<Integer> list, int randomNumber){
        return list.contains(randomNumber);
    }

}
