import java.util.Random;
import java.util.Scanner;

class ID{
    int[] arr, exist;
    Random rd;
    Scanner sc;
    int input;

    public void genByRandom(){
        arr = new int[3];
        exist = new int[10];
        rd = new Random();

        for(int i = 0; i < 3; i++){
            genChoiceAt(i);
        }
    }

    private void genChoiceAt(int idx){
        int t;
        do {
            t = rd.nextInt(9) + 1;
        } while (0 != exist[t]);
        exist[t] = 1;
        arr[idx] = t;
    }

    public void genByTyping(int data){
        exist = new int[10];
        this.input = data;
        arr = new int[3];

        for(int i = 2; -1 < i; i--){
            arr[i] = data % 10;
            data /= 10;
            exist[arr[i]] = 1;
        }
    }

    public String compare(ID o){
        int strkCnt = getStrikeCnt(o.arr);
        int ballCnt = getBallCnt(o.arr);
        if(0 == (strkCnt | ballCnt)){
            return "낫싱";
        }
        if(3 == strkCnt){
            return "same";
        }
        return strikeMSG(strkCnt) + ballMSG(ballCnt);
    }

    private int getStrikeCnt(int[] arr2){
        int retVal = 0;

        for(int i = 0; i < 3; i++){
            int t = (arr[i] == arr2[i]) ? 1 : 0;
            exist[arr[i]] -= t;
            retVal += t;
        }
        return retVal;
    }

    private int getBallCnt(int[] arr2){
        int retVal = 0;
        for(int i = 0; i < 3; i++){
            retVal += exist[arr2[i]];
        }
        return retVal;
    }

    private String strikeMSG(int cnt){
        return (cnt == 0) ? "":(cnt + "스트라이크 ");
    }

    private String ballMSG(int cnt){
        return (cnt == 0) ? "":(cnt + "볼");
    }
}

/*
public class Main {

    public static void main(String[] args) {
        do{
            ID computerID = new ID();
            computerID.genByRandom();
            processToFindComputerID(computerID);
        }while(askForContinue());
    }

    public static void processToFindComputerID(ID computerID){
        ID userID = new ID();
        do {
            int userInput = new Scanner(System.in).nextInt();
            userID.genByTyping(userInput);
        }while(!"same".equals(computerID.compare(userID)));
    }

    public static boolean askForContinue(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        return 2 != sc.nextInt();
    }
}
 */