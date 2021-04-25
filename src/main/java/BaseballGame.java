import java.util.Random;

public class BaseballGame {

    final static Random r = new Random();

	public String generateNumbers(){
		return generateNumbers(null,3);
	}

    private String generateNumbers(String all,int length){
        if(all==null) all="";
        if(all.length() == length){
            return all;
        }
        String number = generateNumberNotZero();
        return  generateNumbers(all+(all.indexOf(number) < 0?number:""),length);
    }

    private String generateNumberNotZero(){
        int number = r.nextInt(10);
        if(number==0) return generateNumberNotZero();
        return number+"";
    }
}
