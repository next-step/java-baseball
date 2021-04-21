import java.util.Scanner;

public class baseball {
    public static void main(String[] args) {
        // scanner
        Scanner sc = new Scanner(System.in);
        // random number
        int[] rnum = new int[3];
        // input number
        int[] num = new int[3];
        // count
        int count = 10;

        // replay
        boolean replay = true;

        System.out.println();
        System.out.println("숫자를 입력해주세요.");
        // replay 하면 랜덤 숫자 다시 생성, count == 0 이면 랜덤 숫자 다시 생성
        while (replay && count > 0) {
            count = 10;
            // 사용자 입력 초기화
            // 다시 시작하는 시점에서 strike ball 초기화
            int strike = 0;
            int ball = 0;

            // 정답 설정
            rnum = set_number();

            // 랜덤 숫자 출력 부분
			System.out.println("랜덤 숫자는 "+rnum[0]+", "+rnum[1]+", "+rnum[2]+"입니다.");
            // count가 0보다 클 경우는 랜덤숫자 재생성을 하지 않고 입력부분부터 loop
            boolean status = false;
            while (count > 0 && !status) {
                num = is_pass_input(sc);

                System.out.println("입력한 숫자는 " + num[0] + ", " + num[1] + ", " + num[2] + "입니다.");

                int[] score = check_game(rnum, num);

                strike = score[0];
                ball = score[1];

                // 답 체크한 후 기회 줄이기
                count--;

                output_message(count, strike, ball);

                status = home_run(strike);
            }

            // 기회를 다 쓰거나 정답을 맞추면 replay check
            if (count == 0 || strike == 3) {
                replay = is_replay_game(sc);
            }
        }
        // 게임종료
        System.out.println("end");
    }

    // 정답 설정
    private static int[] set_number() {
        int[] rnum = new int[3];

        for (int i = 0; i < rnum.length; i++) {
            rnum[i] = ((int) (Math.random() * 9) + 1);
            // 랜덤 중복 숫자 제거
            if(is_overlap(rnum, i)) {
                i--;
            }
        }
        return rnum;
    }

    private static boolean is_overlap(int[] rnum, int i) {
        boolean status = false;
        for (int j = 0; j < i; j++) {
            if (rnum[i] == rnum[j]) {
                status = true;
            }
        }
        return status;
    }

    private static int[] is_pass_input(Scanner sc) {
        int[] num = new int[3];

        boolean pass = false;
        while (!pass) {
            for (int i = 0; i < num.length; i++) {
                check_input_number(sc);

                num[i] = sc.nextInt();

                // 1 ~ 9 한자리 수만 입력가능하게
                check_input_number_range(sc, num, i);
            }
            pass = is_input_number_pass(num);
        }

        return num;
    }

    private static void check_input_number(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();  //값이 숫자가 아니면 버린다.
            System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
        }
    }

    private static void check_input_number_range(Scanner sc, int[] num, int i) {
        while (num[i] >= 10 || num[i] <= 0) {
            System.out.println("1 ~ 9 사이의 한자리 수를 입력해주세요.");
            num[i] = sc.nextInt();
        }
    }

    private static boolean is_input_number_pass(int[] num) {
        boolean status = true;
        // 입력받은 값 중에 중복된 값이 있는지 판단 후 다시 입력
        if (num[0] == num[1] || num[0] == num[2] || num[1] == num[2]) {
            System.out.println("중복 되었습니다. 다시입력해주세요");
            status = false;
        }
        return status;
    }

    private static int[] check_game(int[] rnum, int[] num) {
        int[] result = new int[2];

        int strike = 0;
        int ball = 0;

        // strike ball result
        for (int i = 0; i < 3; i++) {
            int[] temp = new int[2];
            temp = check_ball(rnum, num, i);
            strike += temp[0];
            ball += temp[1];
        }

        result[0] = strike;
        result[1] = ball;

        return result;
    }

    private static int[] check_ball(int[] rnum, int[] num, int i) {
        int[] result = new int[2];
        int strike = 0;
        int ball = 0;

        for (int j = 0; j < 3; j++) {
            String gameball = check_ball_value(rnum, num, i, j);
            if(gameball == "strike") {
                strike++;
            } else if(gameball == "ball") {
                ball++;
            }
        }

        result[0] = strike;
        result[1] = ball;
        return result;
    }

    private static String check_ball_value(int[] rnum, int[] num, int i, int j) {
        String ball = null;
        if (rnum[i] == num[j]) {
            if (i == j) {
                // 숫자와 자리가 모두 같을 때 -> strike
                ball = "strike";
            } else {
                // 숫자만 맞을 경우 -> ball
                ball = "ball";
            }
        }
        return ball;
    }

    private static void output_message(int count, int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크 아웃입니다");
        } else if (count == 0) {
            System.out.println("10번의 기회를 모두 사용하셨습니다.");
        } else {
            System.out.println(strike + " 스트라이크 " + ball + "볼입니다.");
            System.out.println(count + "회 남았습니다.");
        }
    }

    private static boolean home_run(int strike) {
        boolean status = false;
        if (strike == 3) {
            status = true;
        }
        return status;
    }

    private static boolean is_replay_game(Scanner sc) {
        boolean status = false;
        char yn;

        System.out.println("다시 도전하시겠습니까 ? Y(y) / N(n)");
        yn = sc.next().charAt(0);
        if (yn == 'y' || yn == 'Y') {
            status = true;
        }
        return status;
    }
}