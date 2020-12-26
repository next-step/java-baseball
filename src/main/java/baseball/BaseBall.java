package baseball;

public class BaseBall {
    static int comNum1, comNum2, comNum3;

    public static void main(String[] args){
        System.out.println("Hello World!");
    }

    public int setNumTest(){
        while ( (setNum() == 0) || (zeroCheck() == 0));
        return comNum1*100 + comNum2*10 + comNum3;
    }

    private int setNum(){
        comNum1 = (int)(Math.random()*10);
        comNum2 = (int)(Math.random()*10);
        comNum3 = (int)(Math.random()*10);

        if (comNum1 != comNum2 && comNum2 != comNum3 && comNum3 != comNum1) {
            return 1;
        }
        return 0;
    }

    private int zeroCheck() {
        return comNum1 != 0 && comNum2 != 0 && comNum3 != 0 ? 1 : 0;
    }
}
