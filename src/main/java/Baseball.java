import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Baseball {

    int SecretNumber = 0;
    int InputUserNumber = 0;

    char[] secretChar;
    char[] userChar;

    int strike = 0;
    int ball = 0;

    public void makeSecretNumber() {
        Random rnd = new Random();

        int hundred = (rnd.nextInt(9) + 1) * 100;
        int ten = (rnd.nextInt(9) + 1) * 10;
        int one = rnd.nextInt(9) + 1;

        SecretNumber = hundred + ten + one;
        secretChar = ("" + SecretNumber).toCharArray();
    }

    public void inputUserNumber() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("숫자를 입력해 주세요 : ");
        String stringBuffer = null;
        try {
            stringBuffer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputUserNumber = Integer.parseInt(stringBuffer);
        userChar = ("" + InputUserNumber).toCharArray();
    }

    public boolean compare() {
        boolean result;
        this.strike = 0;
        this.ball = 0;
        String output = "";

        strike();

        if (this.ball > 0) {
            output += this.ball + "볼";
        }
        if (this.strike > 0) {
            output += this.strike + "스트라이크";
        }
        if (output.equals("")) {
            output = "낫싱";
        }
        if (this.strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            result = true;
        } else {
            System.out.println(output);
            result = false;
        }
        return result;
    }

    public void strike() {
        for (int i = 0; i < secretChar.length; i++) {
            if (secretChar[i] == userChar[i]) {
                this.strike++;
            }
            ball(i, secretChar[i]);
        }
    }

    public void ball(int paramIndex, char searchChar) {
        for (int i = 0; i < userChar.length; i++) {
            if (i != paramIndex && userChar[i] == searchChar) {
                this.ball++;
            }
        }
    }

    public boolean gameShutdown() {
        boolean result;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        Scanner sc = new Scanner(System.in);
        int action = sc.nextInt();

        if (action == 2) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
