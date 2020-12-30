import java.util.Random;

class ID{
    private int[] arr, exist;
    private Random rd;

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
            t = rd.nextInt();
        } while (0 != exist[t]);
        exist[t] = 1;
        arr[idx] = t;
    }

    public void genByTyping(){
    }

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
}

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
            userID.genByTyping();
        }while(!"same".equals(computerID.compare(userID)));
    }

    public static boolean askForContinue(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        return 2 != sc.nextInt();
    }
}
