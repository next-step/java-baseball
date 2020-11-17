package service;

import interfaces.Player;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PlayerImplement implements Player {
    int inputNum = 0;
    int[] saveInputNumArr = new int[3];

    public int getInputNum() {
        return inputNum;
    }

    public void setInputNum(int inputNum) {
        this.inputNum = inputNum;
    }

    public int[] getSaveInputNumArr() {
        return saveInputNumArr;
    }

    public void setSaveInputNumArr(int[] saveInpuNumArr) {
        this.saveInputNumArr = saveInpuNumArr;
    }

    @Override
    public void inputGuessableNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        this.inputNum = Integer.parseInt(br.readLine());
    }


    @Override
    public void saveInputNumberArr(int inputNumber) {
        int index = 2;
        while(inputNumber>0){
            int remain = inputNumber%10;
            inputNumber /=10;
            saveInputNumArr[index--] = remain;
        }
    }
}
