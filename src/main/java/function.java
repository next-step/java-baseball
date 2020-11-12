import java.util.Random;
import java.util.Scanner;

public class function {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rn = new Random();
        while(true){
            int st = 0;
            int ball = 0;

            Integer a = 1 * (rn.nextInt(9) + 1);
            Integer b = 10 * (rn.nextInt(9) + 1);
            Integer c = 100 * (rn.nextInt(9) + 1);
            String com_nan = String.valueOf((a+b+c));
            System.out.println("COM : " + com_nan);
            while(st != 3) {
                st = 0;
                ball = 0;

//                a = 1 * (rn.nextInt(9) + 1);
//                b = 10 * (rn.nextInt(9) + 1);
//                c = 100 * (rn.nextInt(9) + 1);
//                String me_nan = String.valueOf((a+b+c));
                System.out.println("숫자를 입력해주세요 : ");
                String me_nan = scanner.next();
//                System.out.println();
                System.out.println("ME : " + me_nan);

                String[] com_nan_st = com_nan.split("");
                String[] me_nan_st = me_nan.split("");
                if(me_nan_st.length != 3){
                    System.out.println("다시 입력하세요.");
                    break;
                }
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(com_nan_st[i].equals(me_nan_st[j])){
                            if(i == j){
                                st += 1;
                                break;
                            }else{
                                ball += 1;
                            }
                        }
                    }
                }
                if(st + ball == 0)
                    System.out.println("낫씽".toString());
                else if(ball != 0 & st == 0)
                    System.out.println(ball +"볼");
                else if(ball == 0 & st != 0)
                    System.out.println(st +"스트라이크");
                else if(st == 1 & ball > 2)
                    System.out.println(st +"스트라이크 " + 2 +"볼");
                else if(st == 3)
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                else
                    System.out.println(st +"스트라이크 " + ball +"볼");
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력 하세요.");
            String ch = scanner.next();
//            System.out.println();
            if(ch.equals("1"))
                System.out.println(ch);
            else if(ch.equals("2")) {
                System.out.println(ch);
                break;
            }
            else
                System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println("게임을 종료합니다.");
    }
}
