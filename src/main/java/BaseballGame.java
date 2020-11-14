import java.util.Random;

public class BaseballGame {
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

    public static void main(String[] args) {
        String com = num();
        System.out.print("컴퓨터 수 : " + com);
    }
}
