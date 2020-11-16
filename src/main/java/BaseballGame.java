import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    int strike = 0;
    int ball = 0;
    public String num(){
        Random r = new Random();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int tmp = 0;
        for(int i=0;i<100;i++){
            int j = r.nextInt(9);
            tmp = arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
        }
        String num = ""+arr[0]+arr[1]+arr[2];
        return num;
    }

    public void play(){
        String com = num();
        System.out.println("computer number : " + com);
        String user = "";
        do{
            Scanner sc = new Scanner(System.in);
            user = sc.nextLine();
            System.out.println("input user number : " + user);
            for(int i=0; i<com.length(); i++) {
                for(int j=0; j<user.length(); j++) {
                    if (com.charAt(i) == user.charAt(j)) {
                        if(i==j) {
                            ++strike;
                        }else {
                            ++ball;
                        }
                    }
                }
            }
            if (strike != 0) System.out.print(strike + " strike ");
            if (ball != 0) System.out.print(ball + " ball ");
            if (strike == 0 && ball == 0) System.out.println("Nothing!");
        }while(!com.equals(user));
    }

    public static void main(String[] args) {
        BaseballGame bg = new BaseballGame();
        bg.play();
    }
}
