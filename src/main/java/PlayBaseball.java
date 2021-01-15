public class PlayBaseball {
    public String getResult(int ans, int check){
        int[] ans_arr = {(ans - (ans % 100)) / 100, (ans % 100 - ans % 10) / 10, ans % 10};
        int[] check_arr = {(check - (check % 100)) / 100, (check % 100 - check % 10) / 10, check % 10};
        int strike = 0;
        int ball = 0;
        String res = "";

        if (ans_arr[0] == check_arr[0]) {
            strike++;
        } else if (ans_arr[0] == check_arr[1]) {
            ball++;
        } else if (ans_arr[0] == check_arr[2]) {
            ball++;
        }

        if (ans_arr[1] == check_arr[1]) {
            strike++;
        } else if (ans_arr[1] == check_arr[0]) {
            ball++;
        } else if (ans_arr[1] == check_arr[2]) {
            ball++;
        }

        if (ans_arr[2] == check_arr[2]) {
            strike++;
        } else if (ans_arr[2] == check_arr[0]) {
            ball++;
        } else if (ans_arr[2] == check_arr[1]) {
            ball++;
        }

        String str_strike = Integer.toString(strike);
        String str_ball = Integer.toString(ball);
        res = str_ball + "볼 " + str_strike + "스트라이크";

        return res;
    }

    public static void main(String[] args) throws Exception{

    }
}
