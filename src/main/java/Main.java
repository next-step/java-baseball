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
        this.input = data;
        arr = new int[3];

        for(int i = 2; -1 < i; i--){
            arr[i] = data % 10;
            data /= 10;
        }
    }

    /*
    public String compare(ID o){
        int strkCnt = getStrikeCnt();
        int ballCnt = getBallCnt();
        if(3 == strkCnt){
            return "same";
        }
        return strikeMSG(strkCnt) + ballMSG(ballCnt);
    }
    private int getStrikeCnt(){
    }
    private int getBallCnt(){
    }
    private String strikeMSG(int cnt){
        return cnt + "스트라이크 ";
    }
    private String ballMSG(int cnt){
        return cnt + "볼";
    }
     */
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