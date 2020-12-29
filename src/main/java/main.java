import java.util.Scanner;

public class main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
    }

    public static void problem(){
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String num = sc.next();
        }

    }

    public static boolean showMenu(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = sc.nextInt();

        if(num == 1)
            return true;

        return false;
    }
}
