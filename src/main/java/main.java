import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] com = {(int)(Math.random()*9)+1, (int)(Math.random()*9)+1, (int)(Math.random()*9)+1};
        int[] me = new int[3];

        boolean run = true;
        while(run) {
            int strike = 0;
            int ball = 0;
            for(int i=0; i<3; i++) {
                System.out.print("[" + (i+1) + "]숫자를 입력해주세요 : ");
                int num = scan.nextInt();
                int check = 1;
                for(int j=0; j<i; j++) {
                    if(num==me[j]) {
                        check = -1;
                    }
                }

                if(check == -1) {
                    i -= 1;
                }else {
                    me[i] = num;
                }
            }

            System.out.print("me = [");
            for(int i=0; i<3; i++) {
                System.out.print(me[i] + " ");
            }
            System.out.println("]");

            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    if(me[i] == com[j]) {
                        if(i==j) {
                            strike +=1;
                        }else if(i!=j) {
                            ball +=1;
                        }
                    }
                }
            }

            System.out.println(strike + "스트라이크" + ball + "볼");

            if(strike == 3) {
//			  run = false;
                System.out.println("3개의 숫자를 모두 맞추셨습니다.");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int num2 = scan.nextInt();
                if(num2 == 2) {
                    run = false;
                }else {
                    continue;
                }
            }
        }
    }
}
