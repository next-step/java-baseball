package freecourse1;

public class RandomNumber {

    private static final int SIZE = 3;
    private int[] numbers;

    public RandomNumber() { }

    public int[] getNumbers(){
        return numbers;
    }

    public void make() {
        makeNumbers();
    }

    private void makeNumbers(){
        numbers = new int[SIZE];
        for(int i=0; i<SIZE ; i++) {
            numbers[i] = (int)(Math.random()*9)+1;
            for(int j=0; j<i; j++) {
                if(numbers[i] == numbers[j]){
                    i--;
                    break;
                }
            }
        }
    }

}
