package output;

import message.Message;

public class OutputApi {
    public static void output(Message message){
        System.out.print(message.getMessage());
    }

    public static void outputBallCount(int strike, int ball){
        System.out.println(strike + " 스트라이크 " + ball + " 볼 ");
    }
}
