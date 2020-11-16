import util.BaseBallGameUtil;
import util.GeneratorRandomNumbers;
import util.Validator;

import java.util.*;

import static common.Constant.TEXT_INPUT;


public class BaseBallGame {


    public static void main(String args[]) {

            run();

    }


    private static void run(){

        boolean isContinue = true;

        BaseBallGameUtil baseBallGameUtil = new BaseBallGameUtil();

        // 컴퓨터 랜덤값
        int[] computerNumbers = GeneratorRandomNumbers.generatorNumbers();

        System.out.println(Arrays.toString(computerNumbers));

        while(isContinue){

            int[] userNumbers = userInput();

            isContinue = baseBallGameUtil.baseBallGameUtil(computerNumbers, userNumbers);

        }


    }




    private static int[] userInput(){
        Scanner scanner = new Scanner(System.in);


        String userInput;

        do {

            userInput = scanner.nextLine();

        }while(!validatorCheckNumber(userInput));


        int[] inputNumbers = new int[3];
        System.out.println(TEXT_INPUT);
        String[] input = scanner.nextLine().split("");


        for (int i = 0; i < input.length; i++){

            inputNumbers[i] = Integer.parseInt(userInput);
        }


        return inputNumbers;

    }


    private





}
