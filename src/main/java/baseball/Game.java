package baseball;

import java.util.HashSet;

public class Game {
    static boolean checkNum(int randNum, HashSet<Integer> choosedNum){
        return (randNum != 0) && (!choosedNum.contains(randNum));
    }
    static int chooseNumber(HashSet<Integer> choosedNum){
        boolean find = false;
        int randNum;

        do {
            randNum = (int)(Math.random()*10);
            find = checkNum(randNum, choosedNum);
        } while(!find);

        return randNum;
    }

    static int[] makeNumbers(){
        int result[] = new int[3];
        HashSet<Integer> choosedNum = new HashSet<>();

        for(int idx = 0; idx < 3; idx++){
            result[idx] = chooseNumber(choosedNum);
            choosedNum.add(result[idx]);
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println("start game");
    }
}
