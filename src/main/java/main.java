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

        numballCreate[0] = (int) (Math.random() * 8);
        numballCreate[1] = (int) (Math.random() * 8);
        numballCreate[2] = (int) (Math.random() * 8);

        while (true) {
            if (numballCreate[0] == numballCreate[1]) {

                numballCreate[1] = (int) (Math.random() * 8);
            }

            if (numballCreate[1] == numballCreate[2]) {

                numballCreate[2] = (int) (Math.random() * 8);
            }

            if (numballCreate[0] == numballCreate[2]) {

                numballCreate[2] = (int) (Math.random() * 8);
            }

            if (numballCreate[0] != numballCreate[1] && numballCreate[1] != numballCreate[2]
                    && numballCreate[0] != numballCreate[2]) {

                break;
            }
        }

        numball = String.valueOf(numballCreate[0] + 1) + String.valueOf(numballCreate[1] + 1)
                + String.valueOf(numballCreate[2] + 1);

        System.out.println(numball);

    }

}
