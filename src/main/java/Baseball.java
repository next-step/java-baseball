import java.util.Random;

public class Baseball {

    public static int[] createNumberArray() {
        int[] balls = new int[3];
        Random number = new Random();
        balls[0] = number.nextInt(9) + 1;
        balls[1] = number.nextInt(9) + 1;
        balls[2] = number.nextInt(9) + 1;

        while(balls[0] == balls[1]) {
            balls[1] = number.nextInt(9) + 1;
        }
        while(balls[0] == balls[1] || balls[1] == balls[2]) {
            balls[2] = number.nextInt(9) + 1;
        }

        System.out.println(balls[0]);
        System.out.println(balls[1]);
        System.out.println(balls[2]);

        return balls;
    }

}
