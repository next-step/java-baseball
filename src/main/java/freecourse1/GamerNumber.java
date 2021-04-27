package freecourse1;

public class GamerNumber {

    private static final int SIZE = 3;
    private int[] numbers;

    public GamerNumber() { }

    public int[] getNumbers(){
        return numbers;
    }

    public void read(String input) {
        readNumbers(input);
    }

    private void readNumbers(String input){
        numbers = new int[SIZE];
        for(int i=0; i<SIZE; i++) {
            numbers[i] = Integer.parseInt(input.substring(i,i+1));
        }
    }
}
