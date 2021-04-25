import java.util.Random;

public class BaseballGame {

	public String generateNumbers(){
        Random r = new Random();
		return r.nextInt(10) + "" + r.nextInt(10) + "" + r.nextInt(10);
	}

}
