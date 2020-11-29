package service;


import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public interface BaseBallUtilService {
    Map<String,Integer> setBaseballMap(int strikeCnt, int ballCnt);
    public int getBallCount(int[] computerNumber, int[] userNumber);
    public int getStrikeCount(int [] computerNumber,int [] userNumber);
    public int[] userNumGenerator(String input);
    public int[] numGenerator();
    public Set<Integer> getDeduplicate();
    void StartGame(Scanner scan,int [] computerNumber);
    void resultPrint(Map<String,Integer> map);
    void lastPrint(int strike);
    public Map<String,Object> isReGame(int gameFlag);

}
