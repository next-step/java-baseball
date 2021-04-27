package baseball;

import java.io.*;
import java.util.regex.Pattern;

public class Input {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static final String pattern = "^[0-9]*$";

    private static Output output = new Output();
    private static Message message = new Message();

    public Input() {}

    public static int number() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));


        String input = br.readLine();

        while(!checkInputNumber(input)) {
            print(message.INPUT_NUMBER_INVALID_VALUE);
            input = br.readLine();
        }

        int inputNumber = Integer.parseInt(input);

        return inputNumber;
    }

    public static boolean checkInputNumber(String input) throws IOException {
        if (!Pattern.matches(pattern, input)) {
            return false;
        }

        if (input.length() != 3) {
            return false;
        }

        return true;
    }

    public static void print(String str) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(str);

        bw.flush();
    }

    public static void print(int num) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(num);

        bw.flush();
    }

    public static void endInputOutput() throws IOException {
        br.close();
        bw.close();
    }
}
