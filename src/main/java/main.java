import java.util.*;

public class main {

    static String numball;
    static int strike, ball;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        create();

    }

    public static void create() {

        int numballCreate[] = new int[3];

        numball = "";

        numballCreate[0] = (int) (Math.random() * 9);
        numballCreate[1] = (int) (Math.random() * 9);
        numballCreate[2] = (int) (Math.random() * 9);

        while (true) {
            if (numballCreate[0] == numballCreate[1]) {

                numballCreate[1] = (int) (Math.random() * 9);
            }

            if (numballCreate[1] == numballCreate[2]) {

                numballCreate[2] = (int) (Math.random() * 9);
            }

            if (numballCreate[0] == numballCreate[2]) {

                numballCreate[2] = (int) (Math.random() * 9);
            }

            if (numballCreate[0] != numballCreate[1] && numballCreate[1] != numballCreate[2]
                    && numballCreate[0] != numballCreate[2]) {

                break;
            }
        }

        numball = String.valueOf(numballCreate[0] + 1) + String.valueOf(numballCreate[1] + 1)
                + String.valueOf(numballCreate[2] + 1);

        start();
    }

    public static void start() {

        while (true) {
            strike = 0;
            ball = 0;

            System.out.printf("숫자를 입력해 주세요 : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            System.out.println(input);

            if (input.charAt(0) == numball.charAt(0)) {

                strike++;
            } else if (input.charAt(0) == numball.charAt(1)) {

                ball++;
            } else if (input.charAt(0) == numball.charAt(2)) {

                ball++;
            }

            if (input.charAt(1) == numball.charAt(0)) {

                ball++;
            } else if (input.charAt(1) == numball.charAt(1)) {

                strike++;
            } else if (input.charAt(1) == numball.charAt(2)) {

                ball++;
            }

            if (input.charAt(2) == numball.charAt(0)) {

                ball++;
            } else if (input.charAt(2) == numball.charAt(1)) {

                ball++;
            } else if (input.charAt(2) == numball.charAt(2)) {

                strike++;
            }

            if (ball == 0 && strike == 0) {

                System.out.println("낫싱");
            } else {

                if (ball == 0 && strike != 0) {

                    System.out.println(strike + "스트라이크" + " ");
                } else if (ball != 0 && strike == 0) {

                    System.out.println(ball + "볼");
                } else {

                    System.out.println(ball + "볼" + " " + strike + "스트라이크");
                }

                if (strike == 3) {

                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int input2 = scanner.nextInt();
                    System.out.println(input2);

                    if (input2 == 1) {

                        create();
                    } else {

                        scanner.close();
                        break;
                    }
                }
            }
        }
    }
}
