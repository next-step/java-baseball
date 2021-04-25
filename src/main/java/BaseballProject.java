public class BaseballProject {

    public static void main(String[] args) {
        BaseballRules rules = new BaseballRules();
        String [] baseNumbers = rules.createRandomNumbers(Constants.BASEBALL_DEFAULT_NUMBER_SIZE);
    }

}