import java.util.Random;

public class PlayBaseball {
    public int makeAnswer() {
        Random rand = new Random();

        int[] ans_arr = {0, 0, 0};
        for (int i = 0; i < 3; i++){
            boolean isoverlap = true;
            while (isoverlap) {
                boolean fail = false;
                int num = rand.nextInt(10);
                for (int j = 0; j < i; j++){
                    if (num == ans_arr[j] || num == 0){
                        fail = true;
                        break;
                    }
                }
                if (!fail) {
                    ans_arr[i] = num;
                    isoverlap = false;
                }
            }
        }
        int ans = 100 * ans_arr[0] + 10 * ans_arr[1] + ans_arr[2];
        return ans;
    }

    public static void main(String[] args) throws Exception{

    }
}
