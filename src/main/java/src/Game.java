import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    boolean is_game = true;
    int round = 1;
    int count;
    String strike = "";
    String ball = "" ;
    String result = "not";


    public boolean IsBall(ArrayList computerNum, String aNumber){
        return computerNum.contains(aNumber);
    }

    public void checkRule (ArrayList computerList, ArrayList inputList) {
        int strike = 0;
        this.ball="";
        this.strike="";
        this.result="낫싱";
        boolean strikes[] = {false,false,false};
        boolean ball1 = this.IsBall(computerList, (String) inputList.get(0));
        boolean ball2 = this.IsBall(computerList, (String) inputList.get(1));
        boolean ball3 = this.IsBall(computerList, (String) inputList.get(2));
        System.out.println(computerList.get(0).getClass().getName());
        System.out.println(computerList.get(1));
        System.out.println(computerList.get(2));
        System.out.println(inputList.get(0).getClass().getName());
        System.out.println(inputList.get(1));
        System.out.println(inputList.get(2));
        if (inputList.get(0).equals(computerList.get(0))){
            strike = strike + 1;
            strikes[0] = true;
        }
        if (inputList.get(1).equals(computerList.get(1))){
            strike = strike + 1;
            strikes[1] = true;
        }
        if (inputList.get(2).equals(computerList.get(2))){
            strike = strike + 1;
            strikes[2] = true;
        }
        System.out.println(strike);
        System.out.println(strikes[0]);
        System.out.println(strikes[1]);
        System.out.println(strikes[2]);

        if (strikes[0] && strikes[1] && strikes[2]) {
            strike = 3;
            this.strike = "3 strike";
            this.result = "win";
            this.ReGame();
//            this.is_game = fa;
        } else if ((strikes[0] && strikes[1]) || (strikes[1] && strikes[2]) || (strikes[2] && strikes[0])) {
            strike = 2;
            this.strike = "2 strike";
        } else if (strikes[0] || strikes[1] || strikes[2]) {
            strike = 1;
            this.strike = "1 strike";
        }

        if ((strike <= 1) && (ball1 && ball2) && (ball2 && ball3) && (ball3 && ball1)) {
            this.ball = "2 ball";
        } else if ((strike <= 1) && (ball1) && (ball2) && (ball3)) {
            this.ball = "1 ball";
        }
    }
    public void ReGame() {
        this.round  = this.round + 1;
        this.count  = 0;
        System.out.println("게임을 계속 하시겠습니까? 1.Y / 0.N");
        Scanner input = new Scanner(System.in);
        Boolean YN ;
        YN = input.nextBoolean();
        this.is_game = YN;
    }
    public void result() {
        System.out.println(this.count+ ". " +this.strike+" "+this.ball+" "+this.result);
    }
    public void start() {
        Computer computer = new Computer();
        Input input = new Input();

        while(this.is_game){

            this.count = this.count + 1;
            System.out.println(this.round + ".숫자를 입력하세요");
            input.InputNumData();
            this.checkRule(computer.getComputerNumList(), input.getInputNumList());
            this.result();
        }

    }

}
