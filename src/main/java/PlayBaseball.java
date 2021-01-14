import java.util.Random;

public class PlayBaseball {
    public int makeAnswer() {
        Random rand = new Random();
        int[] ans_arr = {0, 0, 0};

        // 백의 자리에 해당하는 난수 생성
        int num = rand.nextInt(10);
        if (num != 0) {
            ans_arr[0] = num;
        }

        // 십의 자리에 해당하는 난수 생성 및 백의 자리 숫자와 중복 체크
        while (true) {
            num = rand.nextInt(10);
            if (num != 0 && num != ans_arr[0]) {
                ans_arr[1] = num;
                break;
            }
        }

        // 일의 자리에 해당하는 난수 생성 및 중복 체크
        while (true) {
            num = rand.nextInt(10);
            if (num != 0 && num != ans_arr[0] && num != ans_arr[1]) {
                ans_arr[2] = num;
                break;
            }
        }

        int ans = 100 * ans_arr[0] + 10 * ans_arr[1] + ans_arr[2];
        return ans;
    }

    public static void main(String[] args) throws Exception{

    }
}
